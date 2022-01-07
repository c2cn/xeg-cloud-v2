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
public class ImLiveGroupMessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息类型")
    private String type;

    @ApiModelProperty(value = "消息内容")
    private ImLiveGroupMessageContentDTO content;

    public ImLiveGroupMessageDTO(Integer type,Long imId, Integer seatIndex, String name) {
        this.type = "live_system";
        this.content = new ImLiveGroupMessageContentDTO(type,imId, seatIndex, name);
    }
}
