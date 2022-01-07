package com.xeg.cores.topic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/6/21 18:26
 */
@Data
public class TopicXegReturnRecord implements Serializable {
    private static final long serialVersionUID = -8130416445435668039L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 商户交易订单号
     */
    private String tradeOrderNo;


    /**
     * 回调url
     */
    private String returnUrl;

    /**
     * 签名
     */
    private String sign;

    /**
     * 第几轮
     */
    private Integer round;
}
