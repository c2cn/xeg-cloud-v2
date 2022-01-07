package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.utils.Kv;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/****
 * @Description
 * @Author Zhongkun Zhang
 * @Data create in 2021/7/1 9:38
 * @Version 1.0
 **/

@Data
@ApiModel(value = "创建聊天群组对象", description = "创建聊天群组对象")
public class ImCreateGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 群主的UserId（选填）
     */
    @JsonProperty("Owner_Account")
    @ApiModelProperty(value = "群主的UserId（选填）", example = "123")
    private String ownerAccount;

    /**
     * 群组类型：Private/Public/ChatRoom/AVChatRoom（必填）
     */
    @JsonProperty("Type")
    @ApiModelProperty(value = "群组类型：Private/Public/ChatRoom/AVChatRoom", required = true, example = "Private")
    private String type;

    /**
     * 用户自定义群组 ID（选填）
     */
    @JsonProperty("GroupId")
    @ApiModelProperty(value = "用户自定义群组 ID", example = "tmp_orderNo")
    private String groupId;

    /**
     * 群名称（必填）
     */
    @JsonProperty("Name")
    @ApiModelProperty(value = "群名称（必填）", required = true, example = "XX群")
    private String name;

    /**
     * 群简介（选填）
     */
    @JsonProperty("Introduction")
    @ApiModelProperty(value = "群简介（选填）", example = "XX群群简介")
    private String introduction;

    /**
     * 群公告（选填）
     */
    @JsonProperty("Notification")
    @ApiModelProperty(value = "群公告（选填）", example = "XX群群公告")
    private String notification;

    /**
     * 群头像 URL（选填）
     */
    @JsonProperty("FaceUrl")
    @ApiModelProperty(value = "群头像 URL（选填）", example = "http://")
    private String faceUrl;

    /**
     * 最大群成员数量（选填）
     */
    @JsonProperty("MaxMemberCount")
    @ApiModelProperty(value = "最大群成员数量（选填）", hidden = true)
    private Integer maxMemberCount;

    /**
     * 申请加群处理方式（选填）
     */
    @JsonProperty("ApplyJoinOption")
    @ApiModelProperty(value = "申请加群处理方式（选填） FreeAccess（自由加入），NeedPermission（需要验证），DisableApply（禁止加群）", hidden = true)
    private String applyJoinOption;

    /**
     * 初始群成员列表，最多500个（选填）
     */
    @JsonProperty("MemberList")
    @ApiModelProperty(value = "初始群成员列表，最多500个（选填）")
    private List<ImGroupMemberList> memberList;

    /**
     * 初始群成员列表，最多500个（选填）
     */
    @JsonProperty("AppDefinedData")
    @ApiModelProperty(value = "群组维度的自定义字段（选填）")
    private List<Kv> appDefinedData;
}
