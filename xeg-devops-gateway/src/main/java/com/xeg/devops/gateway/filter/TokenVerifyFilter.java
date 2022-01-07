package com.xeg.devops.gateway.filter;

import com.xeg.cores.base.constant.Oauth2Constant;
import com.xeg.cores.base.constant.XegConstant;
import com.xeg.cores.base.exception.enums.ThrowCommonException;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.cores.base.utils.ResponseUtil;
import com.xeg.devops.gateway.properties.ApiProperties;
import com.xeg.devops.gateway.redis.TokenCacheOperation;
import com.xeg.devops.gateway.utils.IpUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关统一的token验证
 *
 * @author ningpeng
 * @since 1.5.8
 */
@Slf4j
@Component
@AllArgsConstructor
public class TokenVerifyFilter implements GlobalFilter, Ordered {
    @Autowired
    private TokenCacheOperation tokenCacheOperation;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 如果未启用网关验证，则跳过
        if (!ApiProperties.getEnable()) {
            return chain.filter(exchange);
        }
        // 定义返回异常信息
        ServerHttpResponse resp = exchange.getResponse();
        ServerHttpRequest req = exchange.getRequest();
        String ipAddr = IpUtils.getIpAddr(req);
        // 获取当前请求url
        String requestUrl = req.getURI().getRawPath();
        // 检测是否在黑名单中,是,则返回异常
        if (checkBlacklist(requestUrl, ipAddr)) {
            return unauthorized(resp, ThrowCommonException.USER_NOT_LOGIN);
        }
        // 检测是否在白名单中,是,则跳过以下token验证
        if (checkWhitelist(requestUrl, ipAddr)) {
            return chain.filter(exchange);
        }
        /**
         * 验证token是否有效
         */
        //先从query中获取token
        String token = exchange.getRequest().getQueryParams().getFirst(Oauth2Constant.TOKEN);
        if (token == null) {
            //query 中未带token,从header中获取
            token = exchange.getRequest().getHeaders().getFirst(Oauth2Constant.TOKEN);
        }
        if (token == null) {
            return unauthorized(resp, ThrowCommonException.USER_NOT_LOGIN);
        }
        // 判断token是否存在于redis,对于只允许一台设备场景适用。
        // 如只允许一台设备登录，需要在登录成功后，查询key是否存在，如存在，则删除此key，提供思路。
        Object obj = tokenCacheOperation.readUserInfoByToken(token);
        if (obj == null) {
            return unauthorized(resp, ThrowCommonException.USER_NOT_LOGIN);
        }

        return chain.filter(exchange);
    }

    /**
     * 检查是否在黑名单中
     *
     * @param path
     * @param ipAddr
     * @return
     */
    private boolean checkBlacklist(String path, String ipAddr) {
        PathMatcher matcher = new AntPathMatcher();
        for (String item : ApiProperties.getBlacklist()) {
            if (matcher.match(item, path)) {
                log.warn("{} is in black list.", path);
                return true;
            }
        }
        for (String item : ApiProperties.getBlackIpList()) {
            if (ipAddr.equals(item)) {
                log.warn("{} is in black list.", ipAddr);
                return true;
            }
        }
        return false;
    }

    /**
     * 检查是否在白名单中
     *
     * @param path
     * @return
     */
    private boolean checkWhitelist(String path, String ipAddr) {
        PathMatcher matcher = new AntPathMatcher();
//        log.info("白名单:" + ApiProperties.getWhitelist());
        for (String item : ApiProperties.getWhitelist()) {
            if (matcher.match(item, path)) {
                log.info("{} is in white list.", path);
                return true;
            }
        }
        for (String ip : ApiProperties.getWhiteIpList()) {
            if (ipAddr.equals(ip)) {
                log.info("{} is in white list.", ipAddr);
                return true;
            }
        }
        return false;
    }

    private Mono<Void> unauthorized(ServerHttpResponse resp, ThrowCommonException throwCommonException) {
        JsonResult result = JsonResultUtils.error(throwCommonException);
        return ResponseUtil.webFluxResponseWriter(resp, XegConstant.JSON_UTF8, HttpStatus.UNAUTHORIZED, result);
    }

    @Override
    public int getOrder() {
        return XegConstant.XEG_UAA_FILTER_ORDER;
    }
}
