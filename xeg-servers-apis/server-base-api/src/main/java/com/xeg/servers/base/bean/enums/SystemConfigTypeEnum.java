package com.xeg.servers.base.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 系统配置类型枚举
 * @Author xulp
 * @Date 2020/9/25 11:10
 */
@Getter
@AllArgsConstructor
public enum SystemConfigTypeEnum {
    ORDER("订单", 1),
    FEEDBACK("意见反馈", 2),
    REGISTRY("用户", 3),
    REPORT("举报", 4),
    RULE("规则", 5);

    private final String name;
    private final int value;

}
