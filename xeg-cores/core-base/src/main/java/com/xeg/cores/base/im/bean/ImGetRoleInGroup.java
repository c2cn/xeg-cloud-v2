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
 * @create: 2021/8/6 20:17
 **/
@Data
@ApiModel(value = "批量查询用户在群组中的身份查询返回对象", description = "批量查询用户在群组中的身份查询返回对象")
public class ImGetRoleInGroup  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要查询的群组 ID", required = true)
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "需要查询的用户帐号，最多支持500个帐号", required = true)
    @JsonProperty("User_Account")
    private List<String> userAccount;

}
