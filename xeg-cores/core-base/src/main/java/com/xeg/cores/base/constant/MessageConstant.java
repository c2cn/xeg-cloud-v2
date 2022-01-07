package com.xeg.cores.base.constant;

import com.xeg.cores.base.utils.StringPool;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/4/26 11:23
 */
public class MessageConstant {
    /**
     * 生产者标识
     */
    public static final String OUTPUT = "output";

    /**
     * 消费者标识
     */
    public static final String INPUT = "input";

    /**
     * 普通消息
     */
    public static final String MSG = "msg";

    /**
     * 消息生产者
     */
    public static final String MSG_OUTPUT = MSG + StringPool.DASH + OUTPUT;

    /**
     * 消息消费者
     */
    public static final String MSG_INPUT = MSG + StringPool.DASH + INPUT;


}
