package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:27
 **/
@Data
@ApiModel(value = "设置全局禁言对象", description = "设置全局禁言对象")
public class ImSetNoSpeaking implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设置禁言配置的帐号", required = true)
    @JsonProperty("Set_Account")
    private String setAccount;

    /**
     * 单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）
     * 0表示取消该帐号的单聊消息禁言
     * 4294967295表示该帐号被设置永久禁言
     * 其它值表示该帐号具体的禁言时间
     */
    @ApiModelProperty(value = "单聊消息禁言时间，单位为秒，非负整数，最大值为4294967295")
    @JsonProperty("C2CmsgNospeakingTime")
    private Long c2cMsgNoSpeakingTime;

    /**
     * 群组消息禁言时间，单位为秒，非负整数，最大值为4294967295（十六进制 0xFFFFFFFF）
     * 0表示取消该帐号的群组消息禁言
     * 4294967295表示该帐号被设置永久禁言
     * 其它值表示该帐号的具体禁言时间
     */
    @ApiModelProperty(value = "群组消息禁言时间，单位为秒，非负整数，最大值为4294967295")
    @JsonProperty("GroupmsgNospeakingTime")
    private Long groupMsgNoSpeakingTime;
}
