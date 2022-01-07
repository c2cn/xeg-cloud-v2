package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@Data
@ApiModel(value = "批量单发单聊消息对象", description = "批量单发单聊消息对象")
public class ImSendMsgBatch implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息接收方ID 列表", required = true)
    @JsonProperty("To_Account")
    private List<String> toAccount;

    @ApiModelProperty(value = "消息发送方 UserID（用于指定发送消息方帐号）", required = true, example = "123")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty(value = "1：把消息同步到 From_Account 在线终端和漫游上；2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游")
    @JsonProperty("SyncOtherMachine")
    private Integer syncOtherMachine;

    @ApiModelProperty(value = "消息随机数，后台用于同一秒内的消息去重。请确保该字段填的是随机数")
    @JsonProperty("MsgRandom")
    private Integer msgRandom;

    @ApiModelProperty(value = "消息离线保存时长（单位：秒），最长为7天（604800秒）")
    @JsonProperty("MsgLifeTime")
    private Long msgLifeTime;

    @ApiModelProperty(value = "消息序列号，后台会根据该字段去重及进行同秒内消息的排序，详细规则请看本接口的功能说明。若不填该字段，则由后台填入随机数")
    @JsonProperty("MsgSeq")
    private Long msgSeq;

    @ApiModelProperty(value = "消息时间戳，UNIX 时间戳（单位：秒）")
    @JsonProperty("MsgTimeStamp")
    private Long msgTimeStamp;

    @ApiModelProperty(value = "消息发送控制选项，是一个 String 数组，只对本条消息有效。\"NoUnread\"表示该条消息不计入未读数。\"NoLastMsg\"表示该条消息不更新会话列表。示例：\"SendMsgControl\": [\"NoUnread\",\"NoLastMsg\"]")
    @JsonProperty("SendMsgControl")
    private String[] sendMsgControl;

    @ApiModelProperty(value = "消息回调禁止开关，只对本条消息有效，ForbidBeforeSendMsgCallback 表示禁止发消息前回调，ForbidAfterSendMsgCallback 表示禁止发消息后回调")
    @JsonProperty("ForbidCallbackControl")
    private String[] forbidCallbackControl;

    @ApiModelProperty(value = "消息体，由一个 element 数组组成，详见字段说明", required = true)
    @JsonProperty("MsgBody")
    private List<ImMsgBody> msgBody;

    @ApiModelProperty(value = "消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    @JsonProperty("CloudCustomData")
    private String cloudCustomData;

    @ApiModelProperty(value = "离线推送信息配置")
    @JsonProperty("OfflinePushInfo")
    private ImOfflinePushInfo offlinePushInfo;
}
