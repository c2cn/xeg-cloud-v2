package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举
 *
 * @Author xulp
 * @since 2021/10/30 17:50
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    WORKER(1, "工人"),
    EMPLOYER(2, "雇主");

    private final Integer value;
    private final String remark;


}
