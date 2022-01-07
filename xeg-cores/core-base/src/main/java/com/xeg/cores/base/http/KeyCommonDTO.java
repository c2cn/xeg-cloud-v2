package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/9 10:05
 **/
@Data
@ApiModel(value = "通用String类型查询对象", description = "通用String类型查询对象")
public class KeyCommonDTO {

    @ApiModelProperty(value = "key", required = true, example = "sdfssdfsd")
    @NotBlank(message = "key 不能为空")
    private String key;
}
