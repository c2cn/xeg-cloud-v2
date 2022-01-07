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
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "批量发送消息返回对象", description = "批量发送消息返回对象")
public class ImSendMsgBatchResult extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息唯一标识，用于撤回。长度不超过50个字符")
    @JsonProperty("MsgKey")
    private String msgKey;

    @ApiModelProperty(value = "批量发送消息失败返回对象")
    @JsonProperty("ErrorList")
    private List<ErrorList> errorList;

    @Data
    @ApiModel(value = "批量发送消息失败返回对象", description = "批量发送消息失败返回对象")
    public static class ErrorList implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "失败帐号")
        @JsonProperty("To_Account")
        private String toAccount;

        @ApiModelProperty(value = "错误码")
        @JsonProperty("ErrorCode")
        private Integer errorCode;
    }
}
