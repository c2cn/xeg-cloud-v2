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
@ApiModel(value = "发送群无痕系统通知对象", description = "发送群无痕系统通知对象")
public class ImGroupSystemNotificationNoTraceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID", required = true, example = "123")
    private String groupId;

    @ApiModelProperty(value = "内容", required = true, example = "内容")
    private String body;
}
