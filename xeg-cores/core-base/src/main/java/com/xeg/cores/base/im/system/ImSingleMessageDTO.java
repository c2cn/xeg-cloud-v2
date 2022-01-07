package com.xeg.cores.base.im.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 11:15
 **/
@Data
@ApiModel(value = "发送单聊消息对象", description = "发送单聊消息对象")
public class ImSingleMessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息发送方ImID", required = true, example = "123")
    private String fromAccount;

    @ApiModelProperty(value = "消息接收方ImID", required = true, example = "123")
    private String toAccount;

    @ApiModelProperty(value = "消息元素类别；目前支持的消息对象包括：TIMTextElem(文本消息)，TIMLocationElem(位置消息)，TIMFaceElem(表情消息)，TIMCustomElem(自定义消息)，TIMSoundElem(语音消息)，TIMImageElem(图像消息)，TIMFileElem(文件消息)，TIMVideoFileElem(视频消息)。")
    private String msgType;

    @ApiModelProperty(value = "内容", required = true, example = "内容")
    private String content;
}
