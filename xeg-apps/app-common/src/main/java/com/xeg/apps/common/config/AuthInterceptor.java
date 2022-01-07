package com.xeg.apps.common.config;

import com.xeg.apps.common.config.annotation.PermissionLogical;
import com.xeg.apps.common.config.annotation.RequirePermissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author ArchieDing
 * @since 2020/09/08
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private AuthProperties properties;

    private PathMatcher matcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
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
