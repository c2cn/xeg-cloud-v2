package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@Data
@ApiModel(value = "待设置的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value对象", description = "待设置的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value对象")
public class ImProfileItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定要设置的资料字段的名称", required = true)
    @JsonProperty("Tag")
    private String tag;

    @ApiModelProperty(value = "待设置的资料字段的值", required = true)
    @JsonProperty("Value")
    private String value;
}
