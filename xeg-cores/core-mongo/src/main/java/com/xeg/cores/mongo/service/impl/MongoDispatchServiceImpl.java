package com.xeg.cores.mongo.service.impl;

import com.xeg.cores.mongo.bean.MongoUserLocation;
import com.xeg.cores.mongo.bean.MongoUserPushOrder;
import com.xeg.cores.mongo.service.MongoDispatchService;
import com.xeg.cores.base.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 派单服务mongo
 * @author: Zhongkun Zhang
 * @create: 2021/6/11 10:09
 **/
@Slf4j
@Service
public class MongoDispatchServiceImpl implements MongoDispatchService {

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 无条件查询
     *
     * @param lng      经度
     * @param lat      纬度
     * @param distance 范围 km
     * @return 符合条件的雇工列表
     */
    @Override
    public List<MongoUserLocation> query(double lng, double lat, double distance) {
        List<MongoUserLocation> res = new ArrayList<>();
        GeoResults<MongoUserLocation> geoResults = mongoTemplate.geoNear(NearQuery.near(lng, lat, Metrics.KILOMETERS)
                .maxDistance(distance), MongoUserLocation.class);
        if (geoResults != null) {
            List<GeoResult<MongoUserLocation>> content = geoResults.getContent();
            if (content != null && content.size() > 0) {
                for (GeoResult<MongoUserLocation> mongoUserLocationGeoResult : content) {
                    res.add(mongoUserLocationGeoResult.getContent());
                }
            }
        }
        return res;
    }

    /**
     * 有条件查询
     *
     * @param lng      经度
     * @param lat      纬度
     * @param distance 范围 km
     * @param query    其他查询条件
     * @return 符合条件的雇工列表
     */
    @Override
    public List<MongoUserLocation> query(double lng, double lat, double distance, Query query) {
        List<MongoUserLocation> res = new ArrayList<>();
        GeoResults<MongoUserLocation> geoResults = mongoTemplate.geoNear(NearQuery.near(lng, lat, Metrics.KILOMETERS)
                .maxDistance(distance).query(query), MongoUserLocation.class);
        if (geoResults != null) {
            List<GeoResult<MongoUserLocation>> content = geoResults.getContent();
            if (content != null && content.size() > 0) {
                for (GeoResult<MongoUserLocation> mongoUserLocationGeoResult : content) {
                    res.add(mongoUserLocationGeoResult.getContent());
                }
            }
        }
        return res;
    }

    /**
     * 保存
     *
     * @param pushOrder
     */
    @Override
    public void save(MongoUserPushOrder pushOrder) {
        mongoTemplate.save(pushOrder);
    }


    /**
     * 查询雇工待抢单列表
     *
     * @param userId
     */
    @Override
    public List<MongoUserPushOrder> getWorkerPushOrderList(Long userId, Long workStartTime, Long minSalary, Long maxSalary, Integer offerType) {
        List<MongoUserPushOrder> list = this.getList(userId, workStartTime, minSalary, maxSalary, offerType, true, 50);
        if (list == null || list.size() < 50) {
            if (list == null) {
                list = new ArrayList<>();
            }
            // 不足50条补数据
            int limit = 50 - list.size();
            List<MongoUserPushOrder> list2 = this.getList(userId, workStartTime, minSalary, maxSalary, offerType, false, limit);
            if (list2 != null && list2.size() > 0) {
                list.addAll(list2);
            }
        }
        return list;
    }

    private List<MongoUserPushOrder> getList(Long userId, Long workStartTime, Long minSalary, Long maxSalary, Integer offerType, boolean first, int limit) {
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(Criteria.where("userId").is(userId));
        if (first) {
            // 10招工中
            criteriaList.add(Criteria.where("orderStatus").is(10));
        } else {
            // 50已取消
            criteriaList.add(Criteria.where("orderStatus").is(50));
        }
        if (workStartTime != null) {
            // 获取当日最大时间
            Long maxTime = DateUtil.getOneDayMaxTimestamp(DateUtil.timestampToLocalDate(workStartTime));
            criteriaList.add(Criteria.where("workStartTime").gte(workStartTime));
            criteriaList.add(Criteria.where("workStartTime").lte(maxTime));
        }
        if (offerType != null) {
            // 竞价单
            criteriaList.add(Criteria.where("offerType").is(offerType));
        } else {
            boolean dingJia = false;
            if (minSalary != null) {
                // 最新薪水
                criteriaList.add(Criteria.where("everyoneSalary").gte(minSalary));
                dingJia = true;
            }
            if (maxSalary != null) {
                // 最大薪水
                criteriaList.add(Criteria.where("everyoneSalary").lte(maxSalary));
                dingJia = true;
            }
            if (dingJia) {
                // 定价单
                criteriaList.add(Criteria.where("offerType").is(1));
            }
        }

        Criteria[] criterias = criteriaList.toArray(new Criteria[0]);
        Query query = new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.andOperator(criterias));
        // 排序
        query.with(Sort.by(Sort.Direction.DESC, "createTime"));
        query.limit(limit);
        return mongoTemplate.find(query, MongoUserPushOrder.class);
    }

    /**
     * 移除雇工待抢单列表中某订单
     *
     * @param orderNo
     * @param userId
     */
    @Override
    public void removeWorkerPushOrder(Long userId, String orderNo) {
        Query query = new Query(Criteria.where("userId").is(userId).and("orderNo").is(orderNo));
        mongoTemplate.remove(query, MongoUserPushOrder.class);
    }

    /**
     * 批量修改雇工订单状态
     *
     * @param orderNo
     * @param orderStatus
     */
    @Override
    public void updatePushOrderStatus(String orderNo, Integer orderStatus) {
        mongoTemplate.updateMulti(new Query(Criteria.where("orderNo")
                        .is(orderNo)), Update.update("orderStatus", orderStatus),
                MongoUserPushOrder.class);
    }

    /**
     * 查询雇工未查看订单数量
     *
     * @param userId   雇工编号
     * @param lastTime 最后一次查看时间
     * @return
     */
    @Override
    public Integer getUnreadOrderNum(Long userId, Long lastTime) {
        Query query = new Query(Criteria.where("userId").is(userId).and("createTime").gt(lastTime));
        List<MongoUserPushOrder> mongoUserPushOrderList = mongoTemplate.find(query, MongoUserPushOrder.class);
        return mongoUserPushOrderList.size();
    }

    @Override
    public MongoUserPushOrder getWorkerNewestOrder(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        query.with(Sort.by(Sort.Direction.DESC, "createTime")).limit(1);
        return mongoTemplate.findOne(query, MongoUserPushOrder.class);
    }
}
