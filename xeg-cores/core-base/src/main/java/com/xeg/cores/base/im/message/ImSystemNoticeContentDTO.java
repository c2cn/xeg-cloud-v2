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
public class ImSystemNoticeContentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String body;

    @ApiModelProperty(value = "图片地址")
    private String image;

    @ApiModelProperty(value = "跳转链接")
    private String url;

    public ImSystemNoticeContentDTO(String title, String body, String image, String url) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.url = url;
    }
}
