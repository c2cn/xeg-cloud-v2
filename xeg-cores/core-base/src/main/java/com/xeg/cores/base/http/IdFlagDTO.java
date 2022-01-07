package com.xeg.cores.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description //TODO
 * @Author 徐鸣昊
 * @Date 2021/9/1
 * @Version 1.0
 */

@Data
@ApiModel(value = "ID对象", description = "ID对象")
public class IdFlagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", required = true, example = "10006")
    @NotNull(message = "id 不能为空")
    private Long id;

    @ApiModelProperty(value = "业务标记 Y是 N否", example = "Y", allowableValues = "Y/N")
    @NotBlank(message = "flag 不能为空")
    private String flag;
}
