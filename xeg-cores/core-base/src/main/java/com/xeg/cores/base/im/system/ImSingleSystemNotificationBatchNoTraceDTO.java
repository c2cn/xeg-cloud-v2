package com.xeg.cores.base.im.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 11:15
 **/
@Data
@ApiModel(value = "批量发送无痕单聊系统通知对象", description = "批量发送无痕单聊系统通知对象")
public class ImSingleSystemNotificationBatchNoTraceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息接收方ImID列表(批量发送使用)",required = true)
    private List<String> toAccountList;

    @ApiModelProperty(value = "内容", required = true, example = "内容")
    private String body;
}
