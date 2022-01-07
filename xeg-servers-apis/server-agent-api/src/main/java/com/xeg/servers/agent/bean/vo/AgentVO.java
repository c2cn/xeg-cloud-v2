package com.xeg.servers.agent.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * -----
 *
 * @Author xulp
 * @since 2021/10/30 16:37
 */
@Data
public class AgentVO implements Serializable {

    @ApiModelProperty(value = "代理编号")
    private Long agentId;

    @ApiModelProperty(value = "管理端账号编号")
    private Long adminId;

    @ApiModelProperty(value = "代理名称")
    private String agentName;

    @ApiModelProperty(value = "上级代理编号")
    private Long parentId;

    @ApiModelProperty(value = "代理类型  1 一级代理 2 二级代理")
    private Integer agentType;

    @ApiModelProperty(value = "用户身份关联编号")
    private Long agentIdentityId;

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "6位邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "手机号")
    private String phone;
}
