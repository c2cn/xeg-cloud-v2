package com.xeg.cores.base.im.enumerate;

/**
 * @author Zhongkun Zhang
 * 消息类别枚举
 */
public enum ImMsgTypeEnum {

    TEXT("文本消息", "TIMTextElem"),
    LOCATION("地理位置消息", "TIMLocationElem"),
    FACE("表情消息", "TIMFaceElem"),
    CUSTOM("自定义消息，当接收方为 iOS 系统且应用处在后台时，此消息类型可携带除文本以外的字段到 APNs。一条组合消息中只能包含一个 TIMCustomElem 自定义消息元素", "TIMCustomElem"),
    SOUND("语音消息", "TIMSoundElem"),
    IMAGE("图像消息", "TIMImageElem"),
    FILE("文件消息", "TIMFileElem"),
    VIDEO_FILE("视频消息", "TIMVideoFileElem"),
    ;

    public final String name;
    public final String value;

    private ImMsgTypeEnum(String name, String value) {
        this.value = value;
        this.name = name;
    }
}
