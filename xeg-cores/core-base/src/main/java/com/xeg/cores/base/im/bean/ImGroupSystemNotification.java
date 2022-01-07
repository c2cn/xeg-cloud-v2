package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 11:15
 **/
@Data
public class ImGroupSystemNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 群组ID
     */
    @JsonProperty("GroupId")
    private String groupId;

    /**
     * 系统通知内容
     */
    @JsonProperty("Content")
    private String content;

    /**
     * 接收者群成员列表，不填或为空表示全员下发，AVChatRoom 群类型仅支持全员下发，不支持指定群成员接收者。
     */
    @JsonProperty("ToMembers_Account")
    private List<String> toMembersAccount;
}
