package com.xeg.devops.gateway.redis;

import com.xeg.cores.base.utils.JsonUtils;
import com.xeg.cores.base.context.UserLoginVO;
import com.xeg.cores.redis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ningpeng
 * @description: token缓存处理
 * @date 2021/4/27 16:35
 */
@Component
public class TokenCacheOperation {
    @Autowired
    private Cache cache;

    /**
     * 用户token信息
     */
    public final static String AUTH_TOKEN = "auth_token";

    /**
     * 获取用户登录信息
     *
     * @param token 用户token
     */
    public Object readUserInfoByToken(String token) {
        return cache.hget(AUTH_TOKEN, token);
    }

    /**
     * 写入用户登录信息
     *
     * @param token 用户token
     */
    public void writeUserInfoByToken(String token, UserLoginVO userLoginVO) {
        cache.hset(AUTH_TOKEN, token, JsonUtils.toJson(userLoginVO));
    }

}
