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
@ApiModel(value = "发送直播群系统通知对象", description = "发送直播群系统通知对象")
public class ImLiveGroupNotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID", required = true, example = "123")
    private String groupId;

    @ApiModelProperty(value = "通知内容")
    private String content;
}
