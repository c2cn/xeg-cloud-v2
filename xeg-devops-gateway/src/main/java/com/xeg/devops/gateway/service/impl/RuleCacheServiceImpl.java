package com.xeg.devops.gateway.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xeg.cores.redis.cache.Cache;
import com.xeg.devops.gateway.entity.BlackList;
import com.xeg.devops.gateway.entity.RuleConstant;
import com.xeg.devops.gateway.service.IRuleCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ningpeng
 */
@Service
public class RuleCacheServiceImpl implements IRuleCacheService {

    @Autowired
    private Cache cache;


    @Override
    public Set<Object> getBlackList(String ip) {
        Set<Object> set = cache.sGet(RuleConstant.getBlackListCacheKey(ip));
        return set;
    }

    @Override
    public Set<Object> getBlackList() {
        return cache.sGet(RuleConstant.getBlackListCacheKey());
    }

    @Override
    public void setBlackList(BlackList blackList) {
        String key = StrUtil.isNotBlank(blackList.getIp()) ? RuleConstant.getBlackListCacheKey(blackList.getIp())
                : RuleConstant.getBlackListCacheKey();
        cache.sSet(key, JSONUtil.toJsonStr(blackList));
    }

    @Override
    public void deleteBlackList(BlackList blackList) {
        String key = StrUtil.isNotBlank(blackList.getIp()) ? RuleConstant.getBlackListCacheKey(blackList.getIp())
                : RuleConstant.getBlackListCacheKey();
    }

    @Override
    public void testRedis() {
        cache.set("test", "1");
    }
}