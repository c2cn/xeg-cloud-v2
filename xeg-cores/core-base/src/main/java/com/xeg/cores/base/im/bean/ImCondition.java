package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 20:17
 **/
@Data
@ApiModel(value = "全员推送条件对象", description = "全员推送条件对象")
public class ImCondition implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签条件的交集。标签是一个不超过50字节的字符串。注意属性推送和标签推送不可同时作为推送条件。TagsAnd 条件中的标签个数不能超过10个")
    @JsonProperty("TagsAnd")
    private String[] tagsAnd;

    @ApiModelProperty(value = "标签条件的并集。标签是一个不超过50字节的字符串。注意属性推送和标签推送不可同时作为推送条件。TagsOr 条件中的标签个数不能超过10个")
    @JsonProperty("TagsOr")
    private String[] tagsOr;

    @ApiModelProperty(value = "属性条件的交集。注意属性推送和标签推送不可同时作为推送条件")
    @JsonProperty("AttrsAnd")
    private List<Map<String, Object>> attrsAnd;

    @ApiModelProperty(value = "属性条件的并集。注意属性推送和标签推送不可同时作为推送条件")
    @JsonProperty("AttrsOr")
    private List<Map<String, Object>> attrsOr;
}
