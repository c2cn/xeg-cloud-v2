package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @description: 群组ID
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@Data
@ApiModel(value = "群组ID数组对象", description = "群组ID数组对象")
public class ImGroupIdList implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID 数组", required = true, example = "123")
    @NotNull(message = "groupIdList 不能为空")
    @JsonProperty("GroupIdList")
    private List<String> groupIdList;
}
