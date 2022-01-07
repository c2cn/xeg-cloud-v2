package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 禁用状态枚举
 */
@Getter
@AllArgsConstructor
public enum IsBlackEnum {
    NO("正常", 0),
    READY("预禁用", 1),
    YES("禁用", 2);

    private final String remark;
    private final Integer value;

}
