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
@ApiModel(value = "发送群组消息对象", description = "发送群组消息对象")
public class ImSendGroupMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群组ID", required = true, example = "123_tmp")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "消息来源帐号，选填。如果不填写该字段，则默认消息的发送者为调用该接口时使用的 App 管理员帐号。除此之外，App 亦可通过该字段“伪造”消息的发送者，从而实现一些特殊的功能需求。需要注意的是，如果指定该字段，必须要确保字段中的帐号是存在的")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty(value = "随机数字，五分钟数字相同认为是重复消息")
    @JsonProperty("Random")
    private Integer random;

    @ApiModelProperty(value = "1表示消息仅发送在线成员，默认0表示发送所有成员，AVChatRoom(直播群)不支持该参数")
    @JsonProperty("OnlineOnlyFlag")
    private Integer onlineOnlyFlag;

    @ApiModelProperty(value = "消息发送权限，NoLastMsg 只对单条消息有效，表示不更新最近联系人会话；NoUnread 不计未读，只对单条消息有效")
    @JsonProperty("SendMsgControl")
    private String[] sendMsgControl;

    @ApiModelProperty(value = "消息回调禁止开关，只对单条消息有效，ForbidBeforeSendMsgCallback 表示禁止发消息前回调，ForbidAfterSendMsgCallback 表示禁止发消息后回调")
    @JsonProperty("ForbidCallbackControl")
    private String[] forbidCallbackControl;

    @ApiModelProperty(value = "消息优先级")
    @JsonProperty("MsgPriority")
    private String msgPriority;

    @ApiModelProperty(value = "消息体，由一个 element 数组组成，详见字段说明", required = true)
    @JsonProperty("MsgBody")
    private List<ImMsgBody> msgBody;

    @ApiModelProperty(value = "消息自定义数据（云端保存，会发送到对端，程序卸载重装后还能拉取到）")
    @JsonProperty("CloudCustomData")
    private String cloudCustomData;

    @ApiModelProperty(value = "离线推送信息配置")
    @JsonProperty("OfflinePushInfo")
    private ImOfflinePushInfo offlinePushInfo;

    @ApiModelProperty(value = "群组@列表")
    @JsonProperty("GroupAtInfo")
    private GroupAtInfo groupAtInfo;

    @Data
    @ApiModel(value = "群组@列表", description = "群组@列表")
    public static class GroupAtInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "为1表示@all,为0表示@某个群成员")
        @JsonProperty("GroupAtAllFlag")
        private Integer groupAtAllFlag;

        @ApiModelProperty(value = "@的具体的群成员")
        @JsonProperty("GroupAt_Account")
        private String groupAtAccount;
    }
}
