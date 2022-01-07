package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 发送验证码类型枚举
 */
@Getter
@AllArgsConstructor
public enum SendSmsTypeEnum {
    LOGIN("登录", 1),
    CHANGE_PWD("修改登录密码", 2),
    REGISTER("注册/修改手机号验证码新手机号是否已注册", 3);

    private final String name;
    private final Integer value;
}
