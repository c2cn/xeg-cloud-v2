package com.xeg.cores.base.im.message;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/10/8 11:44
 **/
@Data
public class PushLiveMsgDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息代号
     */
    private Integer code;

    /**
     * 推送单人imId
     */
    private Long imId;

    /**
     * 推送群liveId
     */
    private Long liveId;

    /**
     * 推送多人imIds
     */
    private List<Long> imIds;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 麦位
     */
    private Integer seatIndex;

    /**
     * name
     */
    private String name;

    /**
     * 推送内容
     */
    private String content;

    /**
     * openId(传值表示要推送)
     */
    private String openId;

    /**
     * phone(传值表示要推送)
     */
    private String phone;
}
