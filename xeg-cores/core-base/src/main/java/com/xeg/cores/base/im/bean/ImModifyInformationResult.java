package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 14:54
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "修改IM资料返回对象", description = "修改IM资料返回对象")
public class ImModifyInformationResult extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "详细的客户端展示信息")
    @JsonProperty("ErrorDisplay")
    private String errorDisplay;
}
