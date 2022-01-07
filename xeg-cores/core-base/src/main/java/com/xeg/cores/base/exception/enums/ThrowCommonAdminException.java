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
public enum ThrowCommonAdminException implements ServiceExceptionAssert {

    /**
     * 用户未登录
     */
    USER_NOT_LOGIN("10400", "用户未登录");






    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
