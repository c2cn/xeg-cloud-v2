package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 群组ID
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@Data
public class CallbackCommand implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建应用时在即时通信 IM 控制台分配的 SDKAppID")
    @JsonProperty("SdkAppid")
    private String sdkAppid;

    @ApiModelProperty(value = "回调命令")
    @JsonProperty("CallbackCommand")
    private String callbackCommand;

    @ApiModelProperty(value = "消息发送者 UserID")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty(value = "消息接收者 UserID")
    @JsonProperty("To_Account")
    private String toAccount;

    @ApiModelProperty(value = "消息的唯一标识，可用于 REST API 撤回单聊消息")
    @JsonProperty("MsgKey")
    private String msgKey;

    @ApiModelProperty(value = "触发本次回调的时间戳，单位为毫秒")
    @JsonProperty("EventTime")
    private Long eventTime;

    @ApiModelProperty(value = "该条消息的下发结果，0表示下发成功，非0表示下发失败")
    @JsonProperty("SendMsgResult")
    private Integer sendMsgResult;

    @ApiModelProperty(value = "用户上下线的信息")
    @JsonProperty("Info")
    private Info info;

    @ApiModelProperty(value = "用户上下线的信息")
    @JsonProperty("MsgBody")
    private List<ImMsgBody> msgBody;

    @Data
    public static class Info implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户上线或者下线的动作，Login 表示上线（TCP 建立），Logout 表示下线（TCP 断开），Disconnect 表示网络断开（TCP 断开）")
        @JsonProperty("Action")
        private String action;

        @ApiModelProperty(value = "用户 UserID")
        @JsonProperty("To_Account")
        private String toAccount;
        /**
         * 用户上下线触发的原因：
         * Login 的原因有 Register：App TCP 连接建立
         * Logout 的原因有 Unregister：App 用户注销帐号导致 TCP 断开
         * Disconnect 的原因有 LinkClose：即时通信 IM 检测到 App TCP 连接断开（例如 kill App，客户端发出 TCP 的 FIN 包或 RST 包）；TimeOut：即时通信 IM 检测到 App 心跳包超时，认为 TCP 已断开（例如客户端网络异常断开，未发出 TCP 的 FIN 包或 RST 包，也无法发送心跳包）。心跳超时时间为400秒
         * 各种具体场景触发的回调 Reason 请参考 可能触发该回调的场景 https://cloud.tencent.com/document/product/269/2570#.E5.8F.AF.E8.83.BD.E8.A7.A6.E5.8F.91.E8.AF.A5.E5.9B.9E.E8.B0.83.E7.9A.84.E5.9C.BA.E6.99.AF
         */
        @ApiModelProperty(value = "用户上下线触发的原因")
        @JsonProperty("Reason")
        private String reason;

    }
}
