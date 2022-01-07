package com.xeg.cores.mongo.service;

import com.xeg.cores.mongo.bean.MongoUserLocation;
import com.xeg.cores.mongo.bean.MongoUserPushOrder;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author 派单服务mongo
 * @description: 用户定位
 * @date 2021/5/10 13:54
 */
public interface MongoDispatchService {

    /**
     * 无条件查询
     *
     * @param lng
     * @param lat
     * @param distance
     * @return
     */
    List<MongoUserLocation> query(double lng, double lat, double distance);

    /**
     * 有条件查询
     *
     * @param lng
     * @param lat
     * @param distance
     * @param query
     * @return
     */
    List<MongoUserLocation> query(double lng, double lat, double distance, Query query);

    /**
     * 保存
     *
     * @param pushOrder
     */
    void save(MongoUserPushOrder pushOrder);

    /**
     * 查询雇工待抢单列表
     *
     * @param userId
     */
    List<MongoUserPushOrder> getWorkerPushOrderList(Long userId, Long workStartTime, Long minSalary, Long maxSalary, Integer offerType);

    /**
     * 移除雇工待抢单列表中某订单
     *
     * @param orderNo
     * @param userId
     */
    void removeWorkerPushOrder(Long userId, String orderNo);


    /**
     * 批量修改雇工订单状态
     *
     * @param orderNo
     * @param orderStatus
     */
    void updatePushOrderStatus(String orderNo, Integer orderStatus);

    /**
     * 查询雇工未查看订单数量
     *
     * @param userId   用户编号
     * @param lastTime 最后一次查询时间
     */
    Integer getUnreadOrderNum(Long userId, Long lastTime);

    /**
     * 查询雇工最新一条订单信息
     *
     * @param userId
     */
    MongoUserPushOrder getWorkerNewestOrder(Long userId);
}
