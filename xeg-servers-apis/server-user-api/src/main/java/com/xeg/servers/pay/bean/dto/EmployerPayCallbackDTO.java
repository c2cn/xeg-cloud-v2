package com.xeg.servers.pay.bean.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
	* @author xian
	* @date   2021年11月4日 上午11:23:28
	* @version v1.0.0
	* @Description	雇主支付回调DTO
	* EmployerPayCallbackDTO.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 上午11:23:28       xian            v1.0.0           Created
 */
@Getter
@Setter
@ApiModel(value = "雇主支付回调对象", description = "雇主支付回调对象")
public class EmployerPayCallbackDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户token", required = true, example = "")
    @NotBlank(message = "用户token不能为空")
    private String token;
    
    @ApiModelProperty(value = "订单编号", required = true, example = "")
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;
    
    @ApiModelProperty(value = "支付业务类型", required = false)
    private Integer sceneType;
    
    @ApiModelProperty(value = "订单来源", required = false, example = "1")
    private Integer orderSource;
    
}
