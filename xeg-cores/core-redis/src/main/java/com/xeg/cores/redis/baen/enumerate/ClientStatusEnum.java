package com.xeg.cores.redis.baen.enumerate;

/**
 * 由sohu tv cache cloud copy过来的
 * 客户端口状态类
 * Created by kingapex on 2018/3/13.
 *
 * @author kingapex
 * @version 1.0
 * @since 7.0.0
 * 2018/3/13
 */
public enum ClientStatusEnum {
    /**
     * 正确
     */
    GOOD(1),
    /**
     * 警告
     */
    WARN(0),
    /**
     * 错误
     */
    ERROR(-1);

    int status;

    ClientStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}