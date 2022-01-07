package com.xeg.servers.base.bean.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "系统配置value对象", description = "系统配置value对象")
public class SystemConfigValueVO implements Serializable {

    @ApiModelProperty(value = "配置值key")
    private String key;
    @ApiModelProperty(value = "配置值value")
    private String value;
    @ApiModelProperty(value = "配置值属性")
    private int type;
}

