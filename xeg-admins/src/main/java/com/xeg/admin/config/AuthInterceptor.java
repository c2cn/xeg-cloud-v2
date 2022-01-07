package com.xeg.admin.config;

import com.xeg.admin.config.annotation.PermissionLogical;
import com.xeg.admin.config.annotation.RequirePermissions;
import com.xeg.cores.base.context.TenantUser;
import com.xeg.cores.base.context.UserHolder;
import com.xeg.cores.base.exception.enums.ThrowCommonAdminException;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.utils.JsonUtils;
import com.xeg.cores.redis.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Set;

/**
 * @author ArchieDing
 * @since 2020/09/08
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Resource
    private TokenUtils tokenUtils;
    @Resource
    private AuthProperties properties;

    private PathMatcher matcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        for (String item : properties.getInitWhitelist()) {
            if (matcher.match(item, path)) {
                log.info("{} is in white list.", path);
                return true;
            }
        }

        TenantUser tenantUser = tokenUtils.parseToken(request);
        if (tenantUser == null) {
            log.warn("request {} without token.", path);
            response.setContentType("application/json; charset=utf-8");
            JsonResult data = JsonResult.error(ThrowCommonAdminException.USER_NOT_LOGIN);
            PrintWriter out = response.getWriter();
            out.print(JsonUtils.toJson(data));
            out.close();
            return false;
        }
        UserHolder.setTenantUser(tenantUser);
        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }
        return super.preHandle(request, response, handler);
    }

    private boolean checkPermission(RequirePermissions permission, Set<String> permissionSet) {
        // 当逻辑为and时，必须同时拥有所有权限
        if (permission.logical() == PermissionLogical.AND) {
            for (String method : permission.value()) {
                if (!permissionSet.contains(method)) {
                    return false;
                }
            }
            return true;
        }
        // 当逻辑为or时，拥有一个权限即可
        for (String method : permission.value()) {
            if (permissionSet.contains(method)) {
                return true;
            }
        }
        return false;
    }
}
