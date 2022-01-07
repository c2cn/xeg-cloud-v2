package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 群成员信息列表
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 20:33
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ImListGroupMemberInfo extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群成员列表")
    @JsonProperty("MemberList")
    private List<MemberList> memberList;

    @ApiModelProperty(value = "App 当前的群组总数")
    @JsonProperty("TotalCount")
    private Integer totalCount;

    @Data
    public static class MemberList implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "成员账号")
        @JsonProperty("Member_Account")
        private String memberAccount;

        @ApiModelProperty(value = "角色")
        @JsonProperty("Role")
        private String role;

        @ApiModelProperty(value = "入群时间")
        @JsonProperty("JoinTime")
        private Long joinTime;

        @ApiModelProperty(value = "")
        @JsonProperty("MsgSeq")
        private Long msgSeq;

        @ApiModelProperty(value = "")
        @JsonProperty("MsgFlag")
        private String msgFlag;

        @ApiModelProperty(value = "最后一次发消息的时间")
        @JsonProperty("LastSendMsgTime")
        private Long lastSendMsgTime;

        @ApiModelProperty(value = "禁言截至时间（秒数）")
        @JsonProperty("ShutUpUntil")
        private Long shutUpUntil;

        @ApiModelProperty(value = "群成员自定义字段")
        @JsonProperty("AppMemberDefinedData")
        private List<ImAppMemberDefinedData> appMemberDefinedData;
    }
}
