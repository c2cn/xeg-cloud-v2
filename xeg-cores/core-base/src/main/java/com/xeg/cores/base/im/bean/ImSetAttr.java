package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@Data
@ApiModel(value = "设置用户属性对象", description = "设置用户属性对象")
public class ImSetAttr implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要设置该 UserID 的资料", required = true)
    @JsonProperty("UserAttrs")
    private List<UserAttrs> userAttrs;

    @Data
    @ApiModel(value = "设置用户属性对象", description = "设置用户属性对象")
    public static class UserAttrs implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "目标用户帐号", required = true, example = "123")
        @JsonProperty("To_Account")
        private String toAccount;

        @ApiModelProperty(value = "属性集合。每个属性是一个键值对，键为属性名，值为该用户对应的属性值。用户属性值不能超过50字节", required = true)
        @JsonProperty("Attrs")
        private List<Map<String,Object>> attrs;
    }
}
