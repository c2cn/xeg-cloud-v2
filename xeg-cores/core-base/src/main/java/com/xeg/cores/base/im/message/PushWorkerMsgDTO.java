package com.xeg.cores.base.im.message;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/10/8 11:44
 **/
@Data
public class PushWorkerMsgDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息代号
     */
    private Integer code;

    /**
     * 推送单人userId
     */
    private Long userId;

    /**
     * 推送多人userIds
     */
    private List<Long> userIds;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 雇主订单编号
     */
    private String employerOrderNo;

    /**
     * 群id
     */
    private String groupId;

    /**
     * 群名字
     */
    private String groupName;

    /**
     * 自定义内容
     */
    private String context;

    /**
     * 保证金id
     */
    private Long depositId;

    /**
     * 金额
     */
    private  BigDecimal money;

    /**
     * openId(传值表示要推送)
     */
    private String openId;

    /**
     * phone(传值表示要推送)
     */
    private String phone;
}
