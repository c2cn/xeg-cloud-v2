package com.xeg.servers.base.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * -----
 *
 * @Author xulp
 * @since 2021/11/1 17:27
 */
@Data
@ApiModel(value = "系统配置查询对象", description = "系统配置查询对象")
public class SystemConfigDTO {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5196902453254598578L;

    @ApiModelProperty(value = "配置类型 1订单 2意见反馈 3注册协议 4举报 5规则")
    @NotNull(message = "配置类型不能为空")
    private Integer type;
    @ApiModelProperty(value = "配置键")
    @NotBlank(message = "配置键不能为空")
    private String key; // 配置键

}
