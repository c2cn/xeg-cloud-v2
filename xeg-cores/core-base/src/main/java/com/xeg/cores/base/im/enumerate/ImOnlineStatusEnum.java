package com.xeg.cores.base.im.enumerate;

/**
 * @author Zhongkun Zhang
 * 消息类别枚举
 */
public enum ImOnlineStatusEnum {

    ONLINE("前台运行状态", "Online"),
    OFFLINE("未登录状态", "Offline"),
    PUSHONLINE("后台运行状态", "PushOnline"),
    ;

    public final String name;
    public final String value;

    private ImOnlineStatusEnum(String name, String value) {
        this.value = value;
        this.name = name;
    }
}
