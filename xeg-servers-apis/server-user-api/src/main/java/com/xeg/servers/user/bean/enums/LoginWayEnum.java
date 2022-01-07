package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录方式枚举
 */
@Getter
@AllArgsConstructor
public enum LoginWayEnum {
    SMS(1, "验证码登录"),
    PWS(2, "密码登录");

    private final Integer value;
    private final String remark;

}
