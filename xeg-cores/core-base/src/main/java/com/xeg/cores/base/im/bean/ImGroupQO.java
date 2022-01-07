package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @description: 群组ID
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:29
 **/
@Data
@ApiModel(value = "群组查询对象", description = "群组查询对象")
public class ImGroupQO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID", required = true, example = "123")
    @NotBlank(message = "groupId 不能为空")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "需要获取哪些信息", example = "Member_Account")
    @JsonProperty("MemberInfoFilter")
    private List<String> memberInfoFilter;
}
