package com.xeg.cores.base.exception.enums;

import com.xeg.cores.base.exception.ServiceExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;



/**
 * @author xulp
 * @since 2021/11/02
 */
@Getter
@AllArgsConstructor
public enum ThrowCommonException implements ServiceExceptionAssert {
    /**
     * 系统错误
     */
    SERVER_ERROR("500", "系统错误"),
    /**
     * feign错误
     */
    FEIGN_ERROR("501", "feign错误"),
    /**
     * 任意错误
     */
    ANY_ERROR("502", "{0}"),
    /**
     * 用户未登录
     */
    USER_NOT_LOGIN("401", "用户未登录"),
    /**
     * 参数错误
     */
    VALID_ERROR("403", "参数错误"),
    /**
     * 页面不存在
     */
    PAGE_NOT_FOUND("404", "页面不存在"),
    /**
     * 权限不足
     */
    PERMISSION_LIMIT("900", "用户权限不足");

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
