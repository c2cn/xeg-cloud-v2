package com.xeg.cores.base.im.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 11:15
 **/
@Data
@ApiModel(value = "发送单聊无痕系统通知对象", description = "发送单聊无痕系统通知对象")
public class ImSingleSystemNotificationNoTraceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息接收方ImID", required = true, example = "123")
    private String toAccount;

    @ApiModelProperty(value = "内容", required = true, example = "内容")
    private String body;
}
