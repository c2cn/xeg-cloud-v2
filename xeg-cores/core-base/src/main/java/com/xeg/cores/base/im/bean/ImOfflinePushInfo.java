package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 19:59
 **/

@Data
@ApiModel(value = "离线推送", description = "离线推送")
public class ImOfflinePushInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "0表示推送，1表示不离线推送")
    @JsonProperty("PushFlag")
    private Integer pushFlag;

    @ApiModelProperty(value = "离线推送内容")
    @JsonProperty("Desc")
    private String desc;

    @ApiModelProperty(value = "离线推送标题。该字段为 iOS 和 Android 共用")
    @JsonProperty("Title")
    private String title;

    @ApiModelProperty(value = "离线推送透传内容")
    @JsonProperty("Ext")
    private String ext;

    @ApiModelProperty(value = "AndroidInfo")
    @JsonProperty("AndroidInfo")
    private AndroidInfo androidInfo;

    @ApiModelProperty(value = "ApnsInfo")
    @JsonProperty("ApnsInfo")
    private ApnsInfo apnsInfo;


    @Data
    @ApiModel(value = "Android 离线推送", description = "Android 离线推送")
    public static class AndroidInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "Android 离线推送声音文件路径")
        @JsonProperty("Sound")
        private String sound;
    }

    @Data
    @ApiModel(value = "ApnsInfo", description = "ApnsInfo")
    public static class ApnsInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "这个字段缺省或者为0表示需要计数，为1表示本条消息不需要计数，即右上角图标数字不增加")
        @JsonProperty("BadgeMode")
        private Integer badgeMode;

        @ApiModelProperty(value = "为1表示开启 iOS 10 的推送扩展，默认为0")
        @JsonProperty("MutableContent")
        private Integer mutableContent;

        @ApiModelProperty(value = "该字段用于标识 APNs 推送的标题，若填写则会覆盖最上层 Title")
        @JsonProperty("Title")
        private String title;

        @ApiModelProperty(value = "该字段用于标识 APNs 推送的子标题")
        @JsonProperty("SubTitle")
        private String subTitle;

        @ApiModelProperty(value = "该字段用于标识 APNs 携带的图片地址，当客户端拿到该字段时，可以通过下载图片资源的方式将图片展示在弹窗上")
        @JsonProperty("Image")
        private String image;
    }
}
