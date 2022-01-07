package com.xeg.servers.user.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户注册传输对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "用户注册传输对象", description = "用户注册传输对象")
public class RegistryDTO implements Serializable {
    private static final long serialVersionUID = -2125540904536255432L;

    @ApiModelProperty(value = "手机号", required = true, example = "15868804722")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "密码,MD5 加密(小写)", required = true, example = "e10adc3949ba59abbe56e057f20f883e")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "手机验证码", required = true, example = "1234")
    @NotBlank(message = "手机验证码不能为空")
    private String smsCode;

    @ApiModelProperty(value = "昵称", required = true, example = "小三子")
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @ApiModelProperty(value = "性别 0 女,1男,2不限", required = true, example = "0")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    @ApiModelProperty(value = "出生年月 格式：yyyy-MM-dd", required = true, example = "1991-09-09")
    @NotBlank(message = "出生年月不能为空")
    private String birthDate;

    @ApiModelProperty(value = "注册身份 1雇工 2雇主", required = true, example = "worker")
    @NotNull(message = "注册身份不能为空")
    private Integer registeredType;

    @ApiModelProperty(value = "代理邀请码", example = "123456")
    @NotBlank(message = "代理邀请码不能为空")
    private String inviteCode;

}
