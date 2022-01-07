package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 10:06
 **/
@Data
@ApiModel(value = "群成员列表对象", description = "群成员列表对象")
public class ImGroupMemberList implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成员（必填）
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty(value = "成员ID", required = true, example = "12312312")
    private String memberAccount;

    /**
     * 赋予该成员的身份，目前备选项只有 Admin（选填）
     */
    @JsonProperty("Role")
    @ApiModelProperty(value = "赋予该成员的身份")
    private String role;
}
