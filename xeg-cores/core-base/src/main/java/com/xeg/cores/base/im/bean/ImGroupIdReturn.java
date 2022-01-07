package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description: 群组ID
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ImGroupIdReturn extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID")
    @JsonProperty("GroupId")
    private String groupId;
}
