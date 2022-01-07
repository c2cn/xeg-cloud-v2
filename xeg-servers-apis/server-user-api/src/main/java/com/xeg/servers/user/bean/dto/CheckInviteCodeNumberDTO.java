package com.xeg.servers.user.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:18
 * @Description 校验二维码对应人数传输对象
 * CheckInviteCodeNumberDTO
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:18 xulp v1.0.0 Created
 */
@Data
@ApiModel(value = "校验二维码对应人数传输对象", description = "校验二维码对应人数传输对象")
public class CheckInviteCodeNumberDTO implements Serializable {
    private static final long serialVersionUID = -8677223976865884936L;

    @ApiModelProperty(value = "代理邀请码", example = "123456")
    @NotBlank(message = "代理邀请码不能为空")
    private String code;

    @ApiModelProperty(value = "登录身份 1工人 2雇主", required = true, example = "0")
    @NotNull(message = "登录身份不能为空")
    private Integer userType;
}
