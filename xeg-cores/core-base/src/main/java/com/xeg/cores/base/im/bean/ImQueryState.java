package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@Data
@ApiModel(value = "批量查询在线状态对象", description = "批量查询在线状态对象")
public class ImQueryState implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要查询这些 ImID 的登录状态，一次最多查询500个 ImID 的状态", required = true)
    @JsonProperty("To_Account")
    private List<String> toAccount;

    @ApiModelProperty(value = "是否需要返回详细的登录平台信息。0表示不需要，1表示需要", required = true)
    @JsonProperty("IsNeedDetail")
    private Integer isNeedDetail;
}
