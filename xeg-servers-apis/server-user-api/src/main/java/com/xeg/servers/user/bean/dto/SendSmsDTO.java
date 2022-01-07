package com.xeg.servers.user.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * -----
 *
 * @Author xulp
 * @since 2021/10/29 15:20
 */
@Data
@ApiModel(value = "发送验证码传输对象", description = "发送验证码传输对象")
public class SendSmsDTO implements Serializable {
    private static final long serialVersionUID = 6095239219798187398L;

    @ApiModelProperty(value = "类型 1登录 2修改登录密码 3注册/修改手机号验证码新手机号是否已注册")
    @NotNull(message = "验证码发送类型不能为空")
    private Integer type;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
