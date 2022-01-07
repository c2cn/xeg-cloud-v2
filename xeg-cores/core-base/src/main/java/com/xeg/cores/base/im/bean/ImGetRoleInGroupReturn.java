package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "批量查询用户在群组中的身份查询返回对象", description = "批量查询用户在群组中的身份查询返回对象")
public class ImGetRoleInGroupReturn extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要查询的用户帐号，最多支持500个帐号", required = true)
    @JsonProperty("UserIdList")
    private List<ImGroupMemberList> userIdList;

}
