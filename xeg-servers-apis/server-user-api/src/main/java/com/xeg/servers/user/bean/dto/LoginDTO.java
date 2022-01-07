package com.xeg.servers.user.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户登录传输对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "用户登录传输对象", description = "用户登录传输对象")
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 2237715213754425223L;

    @ApiModelProperty(value = "手机号", required = true, example = "15868804722")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "密码,MD5 加密(小写)", example = "e10adc3949ba59abbe56e057f20f883e")
    private String password;

    @ApiModelProperty(value = "手机验证码", example = "1234")
    private String smsCode;

    @ApiModelProperty(value = "登录方式 1验证码登录 2密码登录", required = true)
    @NotNull(message = "登录方式不能为空")
    private Integer loginWay;

    @ApiModelProperty(value = "登录身份 1工人 2雇主", required = true, example = "0")
    @NotNull(message = "登录身份不能为空")
    private Integer userType;

}
