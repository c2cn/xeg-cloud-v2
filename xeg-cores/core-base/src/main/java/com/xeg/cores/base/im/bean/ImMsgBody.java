package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/6 15:09
 **/

@Data
@ApiModel(value = "消息内容对象", description = "消息内容对象")
public class ImMsgBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消息元素类别；目前支持的消息对象包括：TIMTextElem(文本消息)，TIMLocationElem(位置消息)，TIMFaceElem(表情消息)，TIMCustomElem(自定义消息)，TIMSoundElem(语音消息)，TIMImageElem(图像消息)，TIMFileElem(文件消息)，TIMVideoFileElem(视频消息)。")
    @JsonProperty("MsgType")
    private String msgType;

    @ApiModelProperty(value = "消息元素的内容，不同的 MsgType 有不同的 MsgContent 格式")
    @JsonProperty("MsgContent")
    private MsgContent msgContent;

    @Data
    @ApiModel(value = "消息元素的内容，不同的 MsgType 有不同的 MsgContent 格式", description = "消息元素的内容，不同的 MsgType 有不同的 MsgContent 格式")
    public static class MsgContent implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "额外数据")
        @JsonProperty("Data")
        private String data;

        @ApiModelProperty(value = "地理位置描述信息")
        @JsonProperty("Desc")
        private String desc;

        @ApiModelProperty(value = "纬度")
        @JsonProperty("Latitude")
        private Double latitude;

        @ApiModelProperty(value = "经度")
        @JsonProperty("Longitude")
        private Double longitude;

        @ApiModelProperty(value = "扩展字段")
        @JsonProperty("Ext")
        private String ext;

        @ApiModelProperty(value = "自定义 APNs 推送铃音")
        @JsonProperty("Sound")
        private String sound;

        @ApiModelProperty(value = "消息内容。当接收方为 iOS 或 Android 后台在线时，作为离线推送的文本展示。")
        @JsonProperty("Text")
        private String text;

        @ApiModelProperty(value = "表情索引，用户自定义")
        @JsonProperty("Index")
        private Long index;

        @ApiModelProperty(value = "语音数据大小，单位：字节")
        @JsonProperty("Size")
        private Long size;

        @ApiModelProperty(value = "语音时长，单位：秒")
        @JsonProperty("Second")
        private Long second;

        @ApiModelProperty(value = "语音下载方式标记。目前 Download_Flag 取值只能为2，表示可通过Url字段值的 URL 地址直接下载语音")
        @JsonProperty("Download_Flag")
        private Integer downloadFlag;

        @ApiModelProperty(value = "图片格式。JPG = 1，GIF = 2，PNG = 3，BMP = 4，其他 = 255")
        @JsonProperty("ImageFormat")
        private Integer imageFormat;

        @ApiModelProperty(value = "文件数据大小，单位：字节")
        @JsonProperty("FileSize")
        private Long fileSize;

        @ApiModelProperty(value = "语音下载地址，可通过该 URL 地址直接下载相应语音")
        @JsonProperty("Url")
        private String url;

        @ApiModelProperty(value = "图片序列号。后台用于索引图片的键值")
        @JsonProperty("UUID")
        private String uuid;

        @ApiModelProperty(value = "原图、缩略图或者大图下载信息")
        @JsonProperty("ImageInfoArray")
        private ImageInfoArray imageInfoArray;

        @ApiModelProperty(value = "视频下载地址。可通过该 URL 地址直接下载相应视频")
        @JsonProperty("VideoUrl")
        private String videoUrl;

        @ApiModelProperty(value = "视频格式，例如 mp4")
        @JsonProperty("VideoFormat")
        private String videoFormat;

        @ApiModelProperty(value = "视频缩略图下载地址。可通过该 URL 地址直接下载相应视频缩略图")
        @JsonProperty("ThumbUrl")
        private String thumbUrl;

        @ApiModelProperty(value = "缩略图格式，例如 JPG、BMP 等")
        @JsonProperty("ThumbFormat")
        private String thumbFormat;

        @ApiModelProperty(value = "视频数据大小，单位：字节")
        @JsonProperty("VideoSize")
        private Long videoSize;

        @ApiModelProperty(value = "视频时长，单位：秒")
        @JsonProperty("VideoSecond")
        private Long videoSecond;

        @ApiModelProperty(value = "视频下载方式标记。目前 VideoDownloadFlag 取值只能为2，表示可通过VideoUrl字段值的 URL 地址直接下载视频")
        @JsonProperty("VideoDownloadFlag")
        private Integer videoDownloadFlag;

        @ApiModelProperty(value = "缩略图大小，单位：字节")
        @JsonProperty("ThumbSize")
        private Long thumbSize;

        @ApiModelProperty(value = "缩略图宽度")
        @JsonProperty("ThumbWidth")
        private Integer thumbWidth;

        @ApiModelProperty(value = "缩略图高度")
        @JsonProperty("ThumbHeight")
        private Integer thumbHeight;

        @ApiModelProperty(value = "视频缩略图下载方式标记。目前 ThumbDownloadFlag 取值只能为2，表示可通过ThumbUrl字段值的 URL 地址直接下载视频缩略图")
        @JsonProperty("ThumbDownloadFlag")
        private Integer thumbDownloadFlag;

        @Data
        @ApiModel(value = "原图、缩略图或者大图下载信息", description = "原图、缩略图或者大图下载信息")
        public static class ImageInfoArray implements Serializable {
            private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "图片类型： 1-原图，2-大图，3-缩略图")
            @JsonProperty("Type")
            private Integer type;

            @ApiModelProperty(value = "图片数据大小，单位：字节")
            @JsonProperty("Size")
            private Long size;

            @ApiModelProperty(value = "图片宽度")
            @JsonProperty("Width")
            private Integer width;

            @ApiModelProperty(value = "图片高度")
            @JsonProperty("Height")
            private Integer height;

            @ApiModelProperty(value = "图片下载地址")
            @JsonProperty("URL")
            private String urL;
        }
    }
}
