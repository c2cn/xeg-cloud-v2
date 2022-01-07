package com.xeg.servers.agent.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * -----
 *
 * @Author xulp
 * @since 2021/10/30 16:37
 */
@Data
public class AgentDTO {

    @ApiModelProperty(value = "代理邀请码")
    @NotBlank(message = "代理邀请码不能为空")
    private String inviteCode;
}
