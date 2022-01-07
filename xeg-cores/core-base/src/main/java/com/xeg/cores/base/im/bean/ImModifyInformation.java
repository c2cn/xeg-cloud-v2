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
 * @create: 2021/8/6 14:54
 **/
@Data
@ApiModel(value = "修改IM资料对象", description = "修改IM资料对象")
public class ImModifyInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要设置该 UserID 的资料", required = true, example = "123")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty(value = "待设置的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value", required = true)
    @JsonProperty("ProfileItem")
    private List<ImProfileItem> profileItem;

}
