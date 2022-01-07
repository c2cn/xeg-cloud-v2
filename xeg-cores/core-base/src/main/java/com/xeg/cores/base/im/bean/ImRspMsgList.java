package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 群组历史聊天记录
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 9:00
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "群组历史聊天记录对象", description = "群组历史聊天记录对象")
public class ImRspMsgList extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群组ID")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "是否返回了请求区间的全部消息,当消息长度太长或者区间太大（超过20）导致无法返回全部消息时，值为0,当消息长度太长或者区间太大（超过20）且所有消息都过期时，值为2")
    @JsonProperty("IsFinished")
    private Integer isFinished;

    @ApiModelProperty(value = "返回的消息列表")
    @JsonProperty("RspMsgList")
    private List<RspMsgList> rspMsgList;

    @Data
    @ApiModel(value = "返回的消息列表", description = "返回的消息列表")
    public static class RspMsgList implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "消息的发送者")
        @JsonProperty("From_Account")
        private String fromAccount;

        @ApiModelProperty(value = "是否是空洞消息，当消息被删除或者消息过期后，MsgBody 为空，该字段为1，撤回的消息，该字段为2")
        @JsonProperty("IsPlaceMsg")
        private String isPlaceMsg;

        @ApiModelProperty(value = "消息内容")
        @JsonProperty("MsgBody")
        private List<ImMsgBody> msgBody;

        @ApiModelProperty(value = "消息的优先级，用于消息去重，有客户端发消息时填写，如果没有填，服务端会自动生成，1表示 High 优先级消息，2表示 Normal 优先级消息，3表示 Low 优先级消息，4表示 Lowest 优先级消息")
        @JsonProperty("MsgPriority")
        private Integer msgPriority;

        @ApiModelProperty(value = "消息随机值，用于对消息去重，有客户端发消息时填写，如果没有填，服务端会自动生成")
        @JsonProperty("MsgRandom")
        private Integer msgRandom;

        @ApiModelProperty(value = "消息 seq，用于标识唯一消息，值越小发送的越早")
        @JsonProperty("MsgSeq")
        private Long msgSeq;

        @ApiModelProperty(value = "消息被发送的时间戳，server 的时间")
        @JsonProperty("MsgTimeStamp")
        private Long msgTimeStamp;
    }
}
