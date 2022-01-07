package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "发送消息返回对象", description = "发送消息返回对象")
public class ImSendMsgResult extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息发送的时间戳，对应后台 server 时间")
    @JsonProperty("MsgTime")
    private Long msgTime;

    @ApiModelProperty(value = "消息序列号，唯一标示一条消息")
    @JsonProperty("MsgSeq")
    private Long msgSeq;
}
