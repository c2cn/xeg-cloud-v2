package com.xeg.servers.chat.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * demo枚举
 */
@Getter
@AllArgsConstructor
public enum DemoEnum {

    DEMO1("demo1", "demo1"),
    DEMO2("demo2", "demo2"),
    DEMO3("demo3", "demo3");

    private final String name;
    private final String value;

}
