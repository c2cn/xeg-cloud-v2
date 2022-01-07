package com.xeg.servers.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_user_info")
@ApiModel(value="UserInfo对象", description="用户信息表")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
      @TableId(value = "id", type = IdType.NONE)
    private Long id;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "密码 MD5 加密")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "性别 0 其它 1男 2女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "出生年月1990-06-02")
    @TableField("birth_date")
    private String birthDate;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "状态 0正常 1禁用")
    @TableField("state")
    private Integer state;

    @ApiModelProperty(value = "黑名单(禁用状态) 0->正常，2->预禁用, 1->禁用")
    @TableField("is_black")
    private Integer isBlack;

    @ApiModelProperty(value = "注册身份(1雇工 2雇）")
    @TableField("registered_type")
    private Integer registeredType;

    @ApiModelProperty(value = "邀请码")
    @TableField("invite_code")
    private String inviteCode;

    @ApiModelProperty(value = "区域编号")
    @TableField("region")
    private String region;

    @ApiModelProperty(value = "支付密码")
    @TableField("pay_password")
    private String payPassword;

    @ApiModelProperty(value = "身份证正面")
    @TableField("card_front")
    private String cardFront;

    @ApiModelProperty(value = "身份证反面")
    @TableField("card_back")
    private String cardBack;

    @ApiModelProperty(value = "代理Id")
    @TableField("agent_id")
    private Long agentId;

    @ApiModelProperty(value = "身份状态 0 普通用户  1 特殊身份")
    @TableField("identity_status")
    private Integer identityStatus;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;


}
