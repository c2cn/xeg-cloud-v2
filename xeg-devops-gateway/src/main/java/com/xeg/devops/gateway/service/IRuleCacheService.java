package com.xeg.devops.gateway.service;

import com.xeg.devops.gateway.entity.BlackList;

import java.util.Set;

/**
 * @author ningpeng
 */
public interface IRuleCacheService {

    /**
     * 根据IP获取黑名单
     *
     * @param ip 　ip
     * @return Set
     */
    Set<Object> getBlackList(String ip);

    /**
     * 查询所有黑名单
     *
     * @return Set
     */
    Set<Object> getBlackList();

    /**
     * 设置黑名单
     *
     * @param blackList 黑名单对象
     */
    void setBlackList(BlackList blackList);

    /**
     * 删除黑名单
     *
     * @param blackList 黑名单对象
     */
    void deleteBlackList(BlackList blackList);

    /**
     * 测试缓存
     */
    void testRedis();
}
