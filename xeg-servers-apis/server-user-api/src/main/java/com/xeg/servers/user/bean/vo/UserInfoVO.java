package com.xeg.servers.user.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息展示对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "用户信息展示对象", description = "用户信息展示对象")
public class UserInfoVO implements Serializable {
    private static final long serialVersionUID = 5323945082016608510L;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "性别 0 其它 1男 2女")
    private Integer sex;

    @ApiModelProperty(value = "出生年月 yyyy-MM-dd")
    private String birthDate;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "状态 0正常 1禁用")
    private Integer state;

    @ApiModelProperty(value = "黑名单(禁用状态) 0->正常，2->预禁用, 1->禁用")
    private Integer isBlack;

    @ApiModelProperty(value = "注册身份 1工人 2雇主")
    private Integer registeredType;

    @ApiModelProperty(value = "用户邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "区域编号")
    private String region;

    @ApiModelProperty(value = "支付密码")
    private String payPassword;

    @ApiModelProperty(value = "身份证正面")
    private String cardFront;

    @ApiModelProperty(value = "身份证反面")
    private String cardBack;

    @ApiModelProperty(value = "代理Id")
    private Long agentId;

    @ApiModelProperty(value = "身份状态 0 普通用户  1 特殊身份")
    private Integer identityStatus;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

}
