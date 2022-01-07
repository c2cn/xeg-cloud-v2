package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 21:02
 **/
@Data
@ApiModel(value = "群组删人对象", description = "群组删人对象")
public class ImDeleteGroupMember implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "要操作的群组（必填）", required = true, example = "tmp_123")
    @NotBlank(message = "groupId 不能为空")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "群成员列表,一次最多删除100个成员", required = true)
    @NotNull(message = "MemberToDel_Account 不能为空")
    @JsonProperty("MemberToDel_Account")
    private List<String> memberList;
}
