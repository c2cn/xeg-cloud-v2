package com.xeg.cores.base.utils;

import com.xeg.cores.base.exception.ServiceException;
import com.xeg.cores.base.exception.enums.ThrowCommonException;
import com.xeg.cores.base.im.ImResponse;
import com.xeg.cores.base.im.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/****
 * @Description
 * @Author Zhongkun Zhang
 * @Data create in 2021/6/25 9:37
 * @Version 1.0
 **/
@Component
@Slf4j
public class SendImMessageUtils {
    @Resource
    private HttpUtils httpUtils;

    /**
     * 创建IM账号
     *
     * @param dto
     * @return
     */
    public void accountImport(String sig, ImAccountImport dto) {
        String res = httpUtils.doPostIm("im_open_login_svc/account_import", sig, JsonUtils.toJson(dto));
        ImResponse resp = JsonUtils.toObject(res, ImResponse.class);
        assert resp != null;
        if (resp.getErrorCode() == 0) {
            return;
        }
        log.error("创建IM用户失败:" + resp.getErrorCode() + ":" + resp.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "创建IM用户失败:" + resp.getErrorCode() + ":" + resp.getErrorInfo());
    }

    /**
     * 创建群组
     *
     * @param dto
     * @return
     */
    public ImGroupIdReturn createGroup(String sig, ImCreateGroup dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/create_group", sig, JsonUtils.toJson(dto));
        ImGroupIdReturn id = JsonUtils.toObject(res, ImGroupIdReturn.class);
        assert id != null;
        if (id.getErrorCode() == 0) {
            return id;
        }
        log.error("创建群组失败:" + id.getErrorCode() + ":" + id.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "创建群组失败:" + id.getErrorCode() + ":" + id.getErrorInfo());
        return new ImGroupIdReturn();
    }

    /**
     * 获取所有群组ID列表
     *
     * @return
     */
    public ImGroupList getAllChatGroup(String sig) {
        String res = httpUtils.doGetIm("group_open_http_svc/get_appid_group_list", sig);
        ImGroupList imGroupList = JsonUtils.toObject(res, ImGroupList.class);
        assert imGroupList != null;
        if (imGroupList.getErrorCode() == 0) {
            return imGroupList;
        }
        log.error("创建群组失败:" + imGroupList.getErrorCode() + ":" + imGroupList.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "发送群组系统通知失败:" + imGroupList.getErrorCode() + ":" + imGroupList.getErrorInfo());
    }

    /**
     * 创建直播群组
     *
     * @param liveId
     * @param imId
     * @return
     */
    public ImResponse createLiveRoomGroup(String sig, Long liveId, Long imId) {
        ImCreateGroup imCreateGroup = new ImCreateGroup();
        imCreateGroup.setGroupId("" + liveId);
        imCreateGroup.setType("AVChatRoom");
        imCreateGroup.setName("" + liveId);
        imCreateGroup.setOwnerAccount("" + imId);
        return new ImResponse();// httpUtils.doPostIm("group_open_http_svc/create_group", JsonUtils.toJson(createGroupDTO));
    }


    /***
     * 发送十人状态的方法
     * @param liveId
     */
    public void sendTenStatus(String sig, Long liveId, Long speakId) {
//        //获取到相应直播间的十人状态
//        List<SeatInfoVO> seatInfoVOList = liveCacheOperation.readSeatList(liveId);
//        //发送IM消息
//        //直播间的时候 groupId 和liveId 是同一个
//        JsonResult<List<SeatInfoVO>> result = new JsonResult<List<SeatInfoVO>>();
//        result.setCode(ImMsgTypeCode.GROUP_LIVE_TEN_STATUS.code);
//        result.setMessage(ImMsgTypeCode.GROUP_LIVE_TEN_STATUS.name);
//        result.setData(seatInfoVOList);
//        String resJsonString = JsonUtils.toJson(result);
//        SendGroupMsgDTO sendGroupMsgDTO = generateImMsgBodyUtils.getSendGroupMsgQO(liveId, speakId, resJsonString);
//
//        httpUtils.doPostIm("group_open_http_svc/send_group_msg", JsonUtils.toJson(sendGroupMsgDTO));
    }

    /**
     * 获取群成员详细资料列表
     *
     * @param dto
     * @return
     */
    public ImListGroupMemberInfo getMemberOfChatGroup(String sig, ImGroupQO dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/get_group_member_info", sig, JsonUtils.toJson(dto));
        ImListGroupMemberInfo imListGroupMemberInfo = JsonUtils.toObject(res, ImListGroupMemberInfo.class);
        assert imListGroupMemberInfo != null;
        if (imListGroupMemberInfo.getErrorCode() == 0) {
            return imListGroupMemberInfo;
        }
        log.error("获取群成员详细资料列表失败:" + imListGroupMemberInfo.getErrorCode() + ":" + imListGroupMemberInfo.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "获取群成员详细资料列表失败:" + imListGroupMemberInfo.getErrorCode() + ":" + imListGroupMemberInfo.getErrorInfo());
    }

    /**
     * 增加群成员
     *
     * @param dto
     * @return
     */
    public ImMemberList addGroupMember(String sig, ImAddGroupMember dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/add_group_member", sig, JsonUtils.toJson(dto));
        ImMemberList imMemberList = JsonUtils.toObject(res, ImMemberList.class);
        assert imMemberList != null;
        if (imMemberList.getErrorCode() == 0) {
            return imMemberList;
        }
        log.error("增加群成员失败:" + imMemberList.getErrorCode() + ":" + imMemberList.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "增加群成员失败:" + imMemberList.getErrorCode() + ":" + imMemberList.getErrorInfo());
    }

    /**
     * 删除群成员
     *
     * @param dto
     * @return
     */
    public ImResponse deleteGroupMember(String sig, ImDeleteGroupMember dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/delete_group_member", sig, JsonUtils.toJson(dto));
        ImResponse imMemberList = JsonUtils.toObject(res, ImMemberList.class);
        assert imMemberList != null;
        if (imMemberList.getErrorCode() == 0) {
            return imMemberList;
        }
        log.error("删除群成员失败:" + imMemberList.getErrorCode() + ":" + imMemberList.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "删除群成员失败:" + imMemberList.getErrorCode() + ":" + imMemberList.getErrorInfo());
    }

    /**
     * 解散群组
     *
     * @param qo
     */
    public ImResponse destroyGroup(String sig, ImGroupId qo) {
        String res = httpUtils.doPostIm("group_open_http_svc/destroy_group", sig, JsonUtils.toJson(qo));
        ImResponse response = JsonUtils.toObject(res, ImResponse.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("解散群组失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "解散群组失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 拉取群历史消息
     *
     * @param qo
     * @return
     */
    public ImRspMsgList groupMsgGetSimple(String sig, ImGroupId qo) {
        Map<String, Object> m = new HashMap<>();
        m.put("GroupId", qo.getGroupId());
        m.put("ReqMsgNumber", 999999);
        String res = httpUtils.doPostIm("group_open_http_svc/group_msg_get_simple", sig, JsonUtils.toJson(m));
        ImRspMsgList response = JsonUtils.toObject(res, ImRspMsgList.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("拉取群历史消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "拉取群历史消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 在群组中发送普通消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgResult sendGroupMsg(String sig, ImSendGroupMsg dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/send_group_msg", sig, JsonUtils.toJson(dto));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("在群组中发送普通消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "在群组中发送普通消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 单发单聊消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgResult sendMsg(String sig, ImSendMsg dto) {
        dto.setMsgRandom(RandomUtils.randomInt(1000000000));
        String res = httpUtils.doPostIm("openim/sendmsg", sig, JsonUtils.toJson(dto));
        ImSendMsgResult response = JsonUtils.toObject(res, ImSendMsgResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("单发单聊消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "单发单聊消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 批量发单聊消息
     *
     * @param dto
     * @return
     */
    public ImSendMsgBatchResult sendMsgBatch(String sig, ImSendMsgBatch dto) {
        dto.setMsgRandom(RandomUtils.randomInt(1000000000));
        String res = httpUtils.doPostIm("openim/batchsendmsg", sig, JsonUtils.toJson(dto));
        ImSendMsgBatchResult response = JsonUtils.toObject(res, ImSendMsgBatchResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("批量发单聊消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "批量发单聊消息失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 查询帐号在线状态
     *
     * @param dto
     * @return
     */
    public String queryState(String sig, ImQueryState dto) {
        String res = httpUtils.doPostIm("openim/querystate", sig, JsonUtils.toJson(dto));
        ImQueryStateResult response = JsonUtils.toObject(res, ImQueryStateResult.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response.getQueryResult().get(0).getStatus();
        }
        log.error("查询帐号在线状态失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
//        throw new ServiceException(ThrowCommonException.ANY_ERROR, "查询帐号在线状态失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        return "Offline";
    }

    /**
     * 设置全局禁言
     *
     * @param dto
     * @return
     */
    public ImResponse setNoSpeaking(String sig, ImSetNoSpeaking dto) {
        String res = httpUtils.doPostIm("openconfigsvr/setnospeaking", sig, JsonUtils.toJson(dto));
        ImResponse response = JsonUtils.toObject(res, ImResponse.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("设置全局禁言失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "设置全局禁言失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 批量查询用户在群组中的身份
     *
     * @param dto
     * @return
     */
    public ImGetRoleInGroupReturn getRoleInGroup(String sig, ImGetRoleInGroup dto) {
        String res = httpUtils.doPostIm("group_open_http_svc/get_role_in_group", sig, JsonUtils.toJson(dto));
        ImGetRoleInGroupReturn response = JsonUtils.toObject(res, ImGetRoleInGroupReturn.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response;
        }
        log.error("批量查询用户在群组中的身份失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        throw new ServiceException(ThrowCommonException.ANY_ERROR, "批量查询用户在群组中的身份失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
    }

    /**
     * 查询群详细信息
     *
     * @param sig
     * @param qo
     * @return
     */
    public String getGroupInfo(String sig, ImGroupIdList qo) {
        return httpUtils.doPostIm("group_open_http_svc/get_group_info", sig, JsonUtils.toJson(qo));
    }

    /**
     * 设置用户资料
     *
     * @param sig
     * @param dto
     */
    public String portraitSet(String sig, ImModifyInformation dto) {
        return httpUtils.doPostIm("profile/portrait_set", sig, JsonUtils.toJson(dto));
    }

    /**
     * 设置用户属性
     *
     * @param sig
     * @param dto
     */
    public void setAttr(String sig, ImSetAttr dto) {
        httpUtils.doPostIm("all_member_push/im_set_attr", sig, JsonUtils.toJson(dto));
    }

    /**
     * 获取应用属性名称
     *
     * @param sig
     * @return
     */
    public String getAttrName(String sig) {
        return httpUtils.doPostIm("all_member_push/im_get_attr_name", sig, "{}");
    }

    /**
     * 设置应用属性名称
     *
     * @param map
     * @return
     */
    public String setAttrName(String sig, Map<String, Map<String, String>> map) {
        return httpUtils.doPostIm("all_member_push/im_set_attr_name", sig, JsonUtils.toJson(map));
    }

    /**
     * 添加用户标签
     *
     * @param sig
     * @param imAddTag
     */
    public void addTag(String sig, ImAddTag imAddTag) {
        httpUtils.doPostIm("all_member_push/im_add_tag", sig, JsonUtils.toJson(imAddTag));
    }

    /**
     * 获取直播群在线人数
     *
     * @param sig
     * @param liveRoomId
     * @return
     */
    public Long getOnlineMemberNum(String sig, String liveRoomId) {
        Map<String, String> m = new HashMap<>();
        m.put("GroupId", liveRoomId);
        String res = httpUtils.doPostIm("group_open_http_svc/get_online_member_num", sig, JsonUtils.toJson(m));
        ImOnlineMemberNumReturn response = JsonUtils.toObject(res, ImOnlineMemberNumReturn.class);
        assert response != null;
        if (response.getErrorCode() == 0) {
            return response.getOnlineMemberNum();
        }
        log.error("获取直播群在线人数失败:" + response.getErrorCode() + ":" + response.getErrorInfo());
        return 0L;
    }
}
