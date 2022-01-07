package com.xeg.servers.user.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: 快速注册页面对象
 * @date 2021/5/14 17:38
 */
@Data
@ApiModel(value = "注册页面对象", description = "注册页面对象")
public class RegistryVO implements Serializable {

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "注册身份(1雇工 2雇）")
    private Integer registeredType;

    @ApiModelProperty(value = "性别 0 女 1 男 2 其他")
    private Integer sex;

    @ApiModelProperty(value = "出生年月1989-11-01")
    private String birthDate;
}
