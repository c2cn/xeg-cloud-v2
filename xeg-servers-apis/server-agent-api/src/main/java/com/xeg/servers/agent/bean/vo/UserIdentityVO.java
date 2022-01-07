package com.xeg.servers.agent.bean.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户身份信息
 */
@Data
@ApiModel(value = "用户身份展示对象", description = "用户身份展示对象")
public class UserIdentityVO implements Serializable {

    private static final long serialVersionUID = -276473091741723597L;

    @ApiModelProperty(value = "代理身份编号")
    private Long agentIdentityId;//

    @ApiModelProperty(value = "身份类型 1劳务市场 2劳务派遣企业 3劳务派遣工人 4主持人 5企业联系人")
    private Integer identityType;

    @ApiModelProperty(value = "代理类型 0普通用户 1一级代理 2二级代理")
    private Integer agentType;

}
