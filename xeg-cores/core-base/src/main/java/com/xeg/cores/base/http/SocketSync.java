package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/4/24 15:21
 */
@Data
@ApiModel(value = "Socket同步返回对象", description = "Socket同步返回对象")
public class SocketSync {
    @ApiModelProperty(value = "Socket超时时间")
    private int timeout;
    @ApiModelProperty(value = "Socket话题队列")
    private String[] topics;
}

