package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@Data
@ApiModel(value = "添加用户标签对象", description = "添加用户标签对象")
public class ImAddTag implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "UserTags", required = true)
    @JsonProperty("UserTags")
    private List<UserTags> userTags;

    @Data
    @ApiModel(value = "设置用户属性对象", description = "设置用户属性对象")
    public static class UserTags implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "目标用户帐号", required = true, example = "123")
        @JsonProperty("To_Account")
        private String toAccount;

        @ApiModelProperty(value = "标签集合", required = true)
        @JsonProperty("Tags")
        private String[] tags;
    }
}
