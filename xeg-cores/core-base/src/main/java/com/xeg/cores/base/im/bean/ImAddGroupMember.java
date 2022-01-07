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
@ApiModel(value = "群组拉人对象", description = "群组拉人对象")
public class ImAddGroupMember implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "要操作的群组（必填）", required = true, example = "tmp_123")
    @NotBlank(message = "groupId 不能为空")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty(value = "群成员列表,一次最多添加300个成员", required = true)
    @NotNull(message = "memberList 不能为空")
    @JsonProperty("MemberList")
    private List<MemberList> memberList;

    @Data
    @ApiModel(value = "群组拉人成员对象", description = "群组拉人成员对象")
    public static class MemberList implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "要添加的群成员ID（必填）", required = true, example = "123")
        @NotBlank(message = "memberAccount 不能为空")
        @JsonProperty("Member_Account")
        private String memberAccount;

        @ApiModelProperty(value = "userType 1雇工，2雇主，3主持人，4管理员", required = true, example = "1")
        @NotNull(message = "userType 不能为空")
        private Integer userType;
    }
}
