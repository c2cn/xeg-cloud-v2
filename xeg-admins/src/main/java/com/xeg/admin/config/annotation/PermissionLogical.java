package com.xeg.admin.config.annotation;

/**
 * @author ArchieDing
 * @since 2020/09/08
 */
public enum PermissionLogical {
    /**
     * 必须同时满足
     */
    AND(0),
    /**
     * 满足任一条件
     */
    OR(1);

    private final int value;

    PermissionLogical(int value) {
        this.value = value;
    }
}
