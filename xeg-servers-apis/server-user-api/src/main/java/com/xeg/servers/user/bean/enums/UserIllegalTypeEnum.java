package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserIllegalTypeEnum {
    FREEZE(1, "冻结"),
    DISABLE(2, "禁用");

    private final Integer value;
    private final String remark;
}
