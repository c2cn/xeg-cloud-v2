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
@ApiModel(value = "通用String类型ID查询对象", description = "通用String类型ID查询对象")
public class IdCommonStringDTO {

    @ApiModelProperty(value = "ID（根据接口名提示进行传参）", required = true, example = "123")
    @NotBlank(message = "id 不能为空")
    private String id;

}
