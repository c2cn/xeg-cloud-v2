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
public class ImLiveGroupMessageContentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "根据语雀格式确定")
    private Integer type;

    @ApiModelProperty(value = "接收方imId")
    private Long imId;

    @ApiModelProperty(value = "-1未上麦 0主持人 1雇主 2-9雇工")
    private Integer seatIndex;

    @ApiModelProperty(value = "内容")
    private String name;

    public ImLiveGroupMessageContentDTO(Integer type,Long imId, Integer seatIndex, String name) {
        this.type = type == null ? 0 : type;
        this.imId = imId;
        this.seatIndex = seatIndex == null ? -1 : seatIndex;
        this.name = name;
    }
}
