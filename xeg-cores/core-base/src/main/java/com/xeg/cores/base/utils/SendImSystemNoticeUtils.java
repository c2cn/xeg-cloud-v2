package com.xeg.cores.base.utils;

import com.xeg.cores.base.im.ImResponse;
import com.xeg.cores.base.im.enumerate.ImMsgTypeEnum;
import com.xeg.cores.base.im.bean.*;
import com.xeg.cores.base.im.message.*;
import com.xeg.cores.base.im.system.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 * @Description
 * @Author Zhongkun Zhang
 * @Data create in 2021/6/25 9:37
 * @Version 1.0
 **/
@Component
@Slf4j
public class SendImSystemNoticeUtils {

    @Resource
    private HttpUtils httpUtils;

    /**
     * 发送群组系统通知
     *
     * @param dto
     * @return
     */
    public ImResponse sendGroupSystemNotification(String sig, ImGroupSystemNotificationDTO dto, ImSystemUserDTO maXiaoYaIm) {
        ImGroupSystemNotification notificationDTO = new ImGroupSystemNotification();
        notificationDTO.setGroupId(dto.getGroupId());
        notificationDTO.setToMembersAccount(dto.getToMembersAccount());
        ImSystemNoticeGroupDTO imDTO = new ImSystemNoticeGroupDTO();
        imDTO.setUser(maXiaoYaIm);
        imDTO.setMessage(new ImSystemNoticeMessageDTO(dto.getTitle(), dto.getBody(), dto.getImage(), dto.getUrl(), dto.getType()));
        notificationDTO.setContent(JsonUtils.toJson(imDTO));

        String res = httpUtils.doPostIm("group_open_http_svc/send_group_system_notification", sig, JsonUtils.toJson(notificationDTO));
        ImResponse response = JsonUtils.toObject(res, ImResponse.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("发送自定义群组系统通知失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "发送自定义群组系统通知失败:" + resp.getErrorCode() + ":" + resp.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 发送自定义直播群系统通知
     *
     * @param dto
     * @return
     */
    public ImResponse sendLiveGroupSystemNotification(String sig, ImLiveGroupNotificationDTO dto) {
        ImGroupSystemNotification notificationDTO = new ImGroupSystemNotification();
        notificationDTO.setGroupId(dto.getGroupId());
        notificationDTO.setContent(dto.getContent());

        String res = httpUtils.doPostIm("group_open_http_svc/send_group_system_notification", sig, JsonUtils.toJson(notificationDTO));
        ImResponse response = JsonUtils.toObject(res, ImResponse.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("发送自定义直播群系统通知失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "发送自定义群组系统通知失败:" + resp.getErrorCode() + ":" + resp.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 在群组中发送自定义消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgResult sendGroupMsg(String sig, ImGroupSystemNotificationDTO dto, ImSystemUserDTO maXiaoYaIm, boolean noTrace) {
        ImSendGroupMsg send = new ImSendGroupMsg();
        send.setGroupId(dto.getGroupId());
        send.setFromAccount(maXiaoYaIm.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImSystemNoticeGroupDTO imDTO = new ImSystemNoticeGroupDTO();
        imDTO.setUser(maXiaoYaIm);
        imDTO.setMessage(new ImSystemNoticeMessageDTO(dto.getTitle(), dto.getBody(), dto.getImage(), dto.getUrl(), dto.getType()));
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(imDTO));
        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        send.setRandom(RandomUtils.randomInt(1000000000));
        if (noTrace) {
            String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
            send.setSendMsgControl(sendMsgControl);
        }
        String res = httpUtils.doPostIm("group_open_http_svc/send_group_msg", sig, JsonUtils.toJson(send));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("在群组中发送自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//         throw new ServiceException(ThrowCommonException.ANY_ERROR, "在群组中发送自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 在群组中发送自定义消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgResult sendLiveGroupMsg(String sig, String groupId, ImLiveGroupMessageContentDTO dto, ImSystemUserDTO maXiaoYaIm) {
        ImSendGroupMsg send = new ImSendGroupMsg();
        send.setGroupId(groupId);
        send.setFromAccount(maXiaoYaIm.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImLiveGroupSendDTO imDTO = new ImLiveGroupSendDTO();
        imDTO.setUser(maXiaoYaIm);
        imDTO.setMessage(new ImLiveGroupMessageDTO(dto.getType(), dto.getImId(), dto.getSeatIndex(), dto.getName()));
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(imDTO));
//        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        send.setRandom(RandomUtils.randomInt(1000000000));
//        String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
//        send.setSendMsgControl(sendMsgControl);
        String res = httpUtils.doPostIm("group_open_http_svc/send_group_msg", sig, JsonUtils.toJson(send));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("在直播群中发送自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//         throw new ServiceException(ThrowCommonException.ANY_ERROR, "在群组中发送自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 单发单聊自定义通知消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgResult sendMsg(String sig, ImSingleSystemNotificationDTO dto, ImSystemUserDTO userDTO, boolean noTrace) {
        ImSendMsg send = new ImSendMsg();
        send.setToAccount(dto.getToAccount());
        send.setFromAccount(userDTO.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImSystemNoticeDTO notice = new ImSystemNoticeDTO();
        notice.setUser(userDTO);
        notice.setMessage(new ImSystemNoticeMessageDTO(dto.getTitle(), dto.getBody(), dto.getImage(), dto.getUrl(), dto.getType()));
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(notice));
        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        if (noTrace) {
            String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
            send.setSendMsgControl(sendMsgControl);
            send.setMsgLifeTime(0L);
        }
        String res = httpUtils.doPostIm("openim/sendmsg", sig, JsonUtils.toJson(send));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("单发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());

//        ImSendMsgResult response = new ImSendMsgResult();
        response.setErrorCode(0);
        return response;
    }

    /**
     * 直播间单人通知
     *
     * @param sig
     * @param toAccount
     * @param content
     * @param userDTO
     * @return
     */
    public ImSendMsgResult sendLiveSingleMsg(String sig, String toAccount, String content, ImSystemUserDTO userDTO) {
        ImSendMsg send = new ImSendMsg();
        send.setToAccount(toAccount);
        send.setFromAccount(userDTO.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        Map<String, Object> notice = new HashMap<>();
        notice.put("user", userDTO);
        Map<String, Object> message = new HashMap<>();
        message.put("type", "live_body");
        message.put("content", content);
        notice.put("message", message);
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(notice));
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
        send.setSendMsgControl(sendMsgControl);
        send.setMsgLifeTime(0L);
        String res = httpUtils.doPostIm("openim/sendmsg", sig, JsonUtils.toJson(send));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("单发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());

//        ImSendMsgResult response = new ImSendMsgResult();
        response.setErrorCode(0);
        return response;
    }
    /**
     * 批量发单聊自定义通知消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgBatchResult sendMsgBatch(String sig, ImSingleSystemNotificationBatchDTO dto, ImSystemUserDTO userDTO, boolean noTrace) {
        ImSendMsgBatch send = new ImSendMsgBatch();
        send.setToAccount(dto.getToAccountList());
        send.setFromAccount(userDTO.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImSystemNoticeDTO notice = new ImSystemNoticeDTO();
        notice.setUser(userDTO);
        notice.setMessage(new ImSystemNoticeMessageDTO(dto.getTitle(), dto.getBody(), dto.getImage(), dto.getUrl(), dto.getType()));
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(notice));
        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        if (noTrace) {
            String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
            send.setSendMsgControl(sendMsgControl);
            send.setMsgLifeTime(0L);
        }
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        String res = httpUtils.doPostIm("openim/batchsendmsg", sig, JsonUtils.toJson(send));
        ImSendMsgBatchResult response = JsonUtils.toObject(res, ImSendMsgBatchResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("批量发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "批量发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 批量发单聊自定义通知消息(直播间)
     *
     * @return
     */
    public ImSendMsgBatchResult sendLiveMsgBatch(String sig,List<String> imIds, String content, ImSystemUserDTO userDTO, boolean noTrace) {
        ImSendMsgBatch send = new ImSendMsgBatch();
        send.setToAccount(imIds);
        send.setFromAccount(userDTO.getId());
        List<ImMsgBody> msgBodys = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        Map<String, Object> notice = new HashMap<>();
        notice.put("user", userDTO);
        Map<String, Object> message = new HashMap<>();
        message.put("type", "live_body");
        message.put("content", content);
        notice.put("message", message);
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(notice));
        imMsgBody.setMsgContent(msgContent);
        msgBodys.add(imMsgBody);
        send.setMsgBody(msgBodys);
        String[] sendMsgControl = {"NoUnread", "NoLastMsg"};
        send.setSendMsgControl(sendMsgControl);
        send.setMsgLifeTime(0L);
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        String res = httpUtils.doPostIm("openim/batchsendmsg", sig, JsonUtils.toJson(send));
        ImSendMsgBatchResult response = JsonUtils.toObject(res, ImSendMsgBatchResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("批量发单聊自定义通知消息(直播间)失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "批量发单聊自定义通知消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

    /**
     * 单发单聊自定义通知消息(修改资料-签名)
     *
     * @param dto
     * @return public ImModifyInformationResult sendMsgNoTrace(String sig, ImSingleSystemNotificationDTO dto, ImSystemUserDTO maXiaoYaIm) {
    ImModifyInformation send = new ImModifyInformation();
    send.setFromAccount(dto.getToAccount());
    List<ImProfileItem> profileItems = new ArrayList<>();
    ImProfileItem profileItem  = new ImProfileItem();
    profileItem.setTag("Tag_Profile_IM_SelfSignature");
    ImSystemNoticeDTO notice = new ImSystemNoticeDTO();
    notice.setUser(maXiaoYaIm);
    notice.setMessage(new ImSystemNoticeMessageDTO(dto.getTitle(), dto.getBody(), dto.getImage(), dto.getUrl()));
    profileItem.setValue(JsonUtils.toJson(notice));
    profileItems.add(profileItem);
    send.setProfileItem(profileItems);
    String res = httpUtils.doPostIm("profile/portrait_set", sig, JsonUtils.toJson(send));
    ImModifyInformationResult response = JsonUtils.toObject(res, ImModifyInformationResult.class);
    assert response != null;
    if (response.getErrorCode() == 0) {
    return response;
    }
    log.error("单发单聊自定义通知消息(无痕)失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    //        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊自定义通知消息(无痕)失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    //        ImModifyInformationResult response = new ImModifyInformationResult();
    response.setErrorCode(0);
    return response;
    }
     */
    /**
     * 全员推送
     *
     * @param dto
     * @return
     */
    public Boolean push(String sig, ImPushDTO dto, ImCondition condition) {
        ImPush send = new ImPush();
        send.setFromAccount("maxiaoya");
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        List<ImMsgBody> msgBody = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(dto));
        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBody.add(imMsgBody);
        send.setMsgBody(msgBody);
        send.setCondition(condition);

        String res = httpUtils.doPostIm("all_member_push/im_push", sig, JsonUtils.toJson(send));
        ImPushResult response = JsonUtils.toObject(res, ImPushResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return true;
        }
        log.error("全员推送失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊自定义通知消息(无痕)失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        ImPushResult response = new ImPushResult();
        return false;
    }

    /**
     * 全员推送（测试接口用）
     *
     * @param dto
     * @return
     */
    public ImPushResult push2(String sig, ImPushDTO dto, ImCondition condition) {
        ImPush send = new ImPush();
        send.setFromAccount("maxiaoya");
        send.setMsgRandom(RandomUtils.randomInt(1000000000));
        List<ImMsgBody> msgBody = new ArrayList<>();
        ImMsgBody imMsgBody = new ImMsgBody();
        imMsgBody.setMsgType(ImMsgTypeEnum.CUSTOM.value);
        ImMsgBody.MsgContent msgContent = new ImMsgBody.MsgContent();
        msgContent.setData(JsonUtils.toJson(dto));
        msgContent.setDesc(dto.getBody());
        imMsgBody.setMsgContent(msgContent);
        msgBody.add(imMsgBody);
        send.setMsgBody(msgBody);
        send.setCondition(condition);

        String res = httpUtils.doPostIm("all_member_push/im_push", sig, JsonUtils.toJson(send));
        ImPushResult response = JsonUtils.toObject(res, ImPushResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("全员推送失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊自定义通知消息(无痕)失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        response.setErrorCode(0);
        return response;
    }

}
