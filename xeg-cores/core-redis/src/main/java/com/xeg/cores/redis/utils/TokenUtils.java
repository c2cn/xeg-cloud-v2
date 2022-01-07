package com.xeg.cores.redis.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xeg.cores.base.context.TenantUser;
import com.xeg.cores.base.context.TokenConstant;
import com.xeg.cores.base.utils.JsonUtils;
import com.xeg.cores.redis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ArchieDing
 * @since 2020/09/08
 */
@Component
public class TokenUtils {

    /**
     * 认证请求
     */
    public static final String TOKEN_HEADER_KEY = "admin:admin_auth_token";
    @Autowired
    private Cache cache;

    public String createToken(TenantUser tenantUser) {
        String token = IdUtil.simpleUUID();
        tenantUser.setToken(token);
        cache.hset(TOKEN_HEADER_KEY, token, tenantUser, 24 * 60 * 60);
        return token;
    }

    public TenantUser parseToken(HttpServletRequest request) {
        String token = request.getParameter(TokenConstant.TOKEN_HEADER_KEY);
        if (StrUtil.isEmpty(token)) {
            token = request.getHeader(TokenConstant.TOKEN_HEADER_KEY);
        }
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        Object bean = cache.hget(TOKEN_HEADER_KEY, token);
        if (bean == null) {
            return null;
        }
        return JsonUtils.toObject(JsonUtils.toJson(bean), TenantUser.class);
    }

    public void deleteToken(String token) {
        cache.hdel(TOKEN_HEADER_KEY, token);
    }
}
