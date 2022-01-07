package com.xeg.cores.base.im.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 11:15
 **/
@Data
@ApiModel(value = "发送群系统通知对象", description = "发送群系统通知对象")
public class ImGroupSystemNotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID", required = true, example = "123")
    private String groupId;

    @ApiModelProperty(value = "标题", required = true, example = "标题")
    private String title;

    @ApiModelProperty(value = "内容", required = true, example = "内容")
    private String body;

    @ApiModelProperty(value = "图片地址")
    private String image;

    @ApiModelProperty(value = "跳转链接")
    private String url;

    @ApiModelProperty(value = "自定义消息类型")
    private String type;

    @ApiModelProperty(value = "是否发送无痕消息", required = true, example = "false")
    private Boolean noTrace;

    @ApiModelProperty(value = "接收者群成员列表，不填或为空表示全员下发，AVChatRoom 群类型仅支持全员下发，不支持指定群成员接收者。")
    @JsonProperty("ToMembers_Account")
    private List<String> toMembersAccount;

    @ApiModelProperty(value = "是否以马小丫的身份发送消息", required = true, example = "false")
    private Boolean isMaxiaoya;

    @ApiModelProperty(value = "消息发送方ImID", example = "123")
    private String fromAccount;

    @ApiModelProperty(value = "发送方名字")
    private String fromName;

    @ApiModelProperty(value = "发送方头像")
    private String fromAvatar;

    @ApiModelProperty(value = "发送方角色 worker/employer/admin/customer_service/presenter")
    private String fromRole;
}
