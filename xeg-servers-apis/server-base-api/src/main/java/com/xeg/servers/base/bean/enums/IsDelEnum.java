package com.xeg.servers.base.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IsDelEnum {

    NO(0, "正常"),
    YES(1, "删除");

    private final Integer value;
    private final String remark;

}
