package com.xeg.cores.mongo.service;

import com.xeg.cores.mongo.dto.MongoUserLocationDTO;
import com.xeg.cores.mongo.vo.MongoLocationVO;

import java.util.List;

/**
 * @author ningpeng
 * @description: 用户定位
 * @date 2021/5/10 13:54
 */
public interface MongoUserLocationService {

    /**
     * 用户上传定位信息
     *
     * @param mongoUserLocationDTO
     * @return
     */
    void uploadLocation(MongoUserLocationDTO mongoUserLocationDTO);

    /**
     * 获取区域雇工人数
     *
     * @param areaCode
     * @return
     */
    long getAreaWorkerNum(String areaCode);

    /**
     * 附近工人列表数量
     *
     * @param m
     * @return
     */
    int getNearbyWorkerListCount(MongoUserLocationDTO m);

    /**
     * APP雇主首页获取当前区域雇工列表
     *
     * @param m
     * @return
     */
    List<MongoLocationVO> getAreaWorkerListForEmployerApp(MongoUserLocationDTO m);
}
