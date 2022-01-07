package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 群成员自定义字段
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:24
 **/
@Data
@ApiModel(value = "群成员自定义字段对象", description = "群成员自定义字段对象")
public class ImAppMemberDefinedData implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Value")
    private String value;
}
