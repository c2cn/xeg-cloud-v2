package com.xeg.servers.base.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @PackageName：com.xiaoergekeji.server.base.api.bean.dto
 * @ClassName：IdStringDTO
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 19:26
 */
@Data
public class IdStringDTO {

    @ApiModelProperty("主键")
    @NotBlank(message = "主键不能为空")
    private String id;

}
