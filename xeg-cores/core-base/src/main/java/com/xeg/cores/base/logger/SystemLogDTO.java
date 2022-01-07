package com.xeg.cores.base.logger;

import lombok.Data;

/**
 * @author ArchieDing
 * @since 2020/09/07
 */
@Data
public class SystemLogDTO {
    /**
     * 日志类型
     */
    private String type;

    /**
     * 日志内容
     */
    private String value;

    /**
     * 操作类
     */
    private String className;

    /**
     * 操作函数
     */
    private String methodName;

    /**
     * 传入参数
     */
    private String params;

    /**
     * 执行结果
     */
    private String result;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;
}
