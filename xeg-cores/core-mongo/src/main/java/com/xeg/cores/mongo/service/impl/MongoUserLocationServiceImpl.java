package com.xeg.cores.mongo.service.impl;

import com.xeg.cores.mongo.bean.MongoUserLocation;
import com.xeg.cores.mongo.dto.MongoUserLocationDTO;
import com.xeg.cores.mongo.service.MongoUserLocationService;
import com.xeg.cores.mongo.vo.MongoLocationVO;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.cores.base.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/6/11 10:10
 **/
@Slf4j
@Service
public class MongoUserLocationServiceImpl implements MongoUserLocationService {

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 用户上传定位信息
     *
     * @param mongoUserLocationDTO
     * @return
     */
    @Override
    public void uploadLocation(MongoUserLocationDTO mongoUserLocationDTO) {
        //将用户信息 bean转换成工人信息mongodb bean
        MongoUserLocation userLocation = new MongoUserLocation();
        //删除上一条定位信息
        mongoTemplate.remove(
                new Query(Criteria.where("userId").is(mongoUserLocationDTO.getUserId())),
                MongoUserLocation.class);
        BeanUtils.copyProperties(mongoUserLocationDTO, userLocation);
        HashMap<String, Object> loc = new HashMap<String, Object>();
        loc.put("type", "Point");
        loc.put("coordinates", new Double[]{mongoUserLocationDTO.getLng(),
                mongoUserLocationDTO.getLat()});
        userLocation.setLoc(loc);
        userLocation.setUpdateTime(DateUtil.getTimestamp());

        // 保存新的信息
        mongoTemplate.save(userLocation);
    }

    /**
     * 获取区域雇工人数
     *
     * @param areaCode
     * @return
     */
    @Override
    public long getAreaWorkerNum(String areaCode) {
        Criteria criteria1 = Criteria.where("areaCode").is(areaCode);
        // 获取当天零点时间戳
        long currentDate = DateUtil.getTodayMinTimestamp();
        Criteria criteria2 = Criteria.where("updateTime").gte(currentDate);
        Query query = new Query();
        query.addCriteria(criteria1);
        query.addCriteria(criteria2);
        return mongoTemplate.count(query, MongoUserLocation.class);
    }

    /**
     * 附近工人数
     *
     * @param vo
     * @return
     */
    @Override
    public int getNearbyWorkerListCount(MongoUserLocationDTO vo) {
        Query query = new Query();
        // 获取当天零点时间戳
        long currentDate = DateUtil.getTodayMinTimestamp();
        Criteria criteria2 = Criteria.where("updateTime").gte(currentDate);
        query.addCriteria(criteria2);
        query.limit(50);

        // 默认是按照距离由近到远排序的
        List<MongoLocationVO> res = new ArrayList<>();
        GeoResults<MongoUserLocation> geoResults = mongoTemplate.geoNear(NearQuery.near(vo.getLng(), vo.getLat(), Metrics.KILOMETERS)
                .maxDistance(vo.getRange()).query(query), MongoUserLocation.class);
        if (geoResults == null) {
            return 0;
        }
        return geoResults.getContent().size();
    }

    /**
     * APP雇主首页获取当前区域雇工列表
     *
     * @param vo
     * @return
     */
    @Override
    public List<MongoLocationVO> getAreaWorkerListForEmployerApp(MongoUserLocationDTO vo) {

        Query query = new Query();
        // 城市边界处需要查询周边的话，不能加区域限制
        //        Criteria criteria1 = Criteria.where("areaCode").is(vo.getAreaCode());
        //        query.addCriteria(criteria1);

        // 获取当天零点时间戳
        long currentDate = DateUtil.getTodayMinTimestamp();
        Criteria criteria2 = Criteria.where("updateTime").gte(currentDate);
        query.addCriteria(criteria2);
        query.limit(50);

        // 默认是按照距离由近到远排序的
        List<MongoLocationVO> res = new ArrayList<>();
        GeoResults<MongoUserLocation> geoResults = mongoTemplate.geoNear(NearQuery.near(vo.getLng(), vo.getLat(), Metrics.KILOMETERS)
                .maxDistance(vo.getRange()).query(query), MongoUserLocation.class);
        if (geoResults != null) {
            List<GeoResult<MongoUserLocation>> content = geoResults.getContent();
            if (content != null && content.size() > 0) {
                for (GeoResult<MongoUserLocation> mongoUserLocationGeoResult : content) {
                    MongoUserLocation content1 = mongoUserLocationGeoResult.getContent();
                    MongoLocationVO locationVO = new MongoLocationVO();
                    HashMap<String, Object> loc = content1.getLoc();
                    List<Double> coordinates = (List<Double>) loc.get("coordinates");
                    locationVO.setLng(coordinates.get(0));
                    locationVO.setLat(coordinates.get(1));
                    res.add(locationVO);
                    // 打印出距离
//                    System.out.println(mongoUserLocationGeoResult.getDistance());
                }
            }
        }
        return res;
    }
}
