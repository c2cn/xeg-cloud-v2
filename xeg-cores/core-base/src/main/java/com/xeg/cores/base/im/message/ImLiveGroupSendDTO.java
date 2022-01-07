package com.xeg.cores.base.im.message;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@Data
public class ImLiveGroupSendDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户信息体")
    private ImSystemUserDTO user;

    @ApiModelProperty(value = "发送消息体")
    private ImLiveGroupMessageDTO message;

}
