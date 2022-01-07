package com.xeg.cores.base.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xulp
 * @since 2021/11/02
 */
@Getter
@AllArgsConstructor
public enum ThrowLiveException {
    /**
     * 排队失败
     */
    LIVE_APPLY_QUEUE_ERROR("6001020", "排队失败"),
    /**
     * 不可重复排队
     */
    LIVE_QUEUE_EXIST_ERROR("6001021", "不可重复排队"),
    /**
     * 排队数量达到上限
     */
    LIVE_WORKER_QUEUE_COUNT_ERROR("6001022", "排队数量达到上限"),
    /**
     * 取消排队失败
     */
    LIVE_WORKER_QUEUE_CANCEL_ERROR("6001023", "取消排队失败"),
    /**
     * 您已成单,不可议价
     */
    LIVE_ORDER_OFFER_ERROR("6001024", "您已成单,不可议价"),
    /**
     * 你已成单,不可重复排队
     */
    LIVE_WORKER_FINISHED_ORDER_ERROR("6001025", "你已成单,不可重复排队"),
    /**
     * 不可重复上麦
     */
    LIVE_LINEING_EXIST_ERROR("6001026", "不可重复上麦"),
    /**
     * 工人已经下麦，请勿重复下麦
     */
    LIVE_WORKER_ALREADY_DOWNWHEAT_ERROR("6003002", "工人已经下麦，请勿重复下麦"),
    /**
     * 当前麦上无订单，不能修改订单
     */
    LIVE_ORDER_NOT_UPDATE_ERROR("6003003", "当前麦上无订单，不能修改订单"),
    /**
     * 操作失败，工人已被选中
     */
    LIVE_OPERATION_FAILED("6003005", "操作失败，工人已被选中"),
    /**
     * 订单不存在不能上麦
     */
    LIVE_ORDER_NOT_EXIST("6003006", "订单不存在不能上麦"),
    /**
     * 操作冲突
     */
    LIVE_OPERATION_FREQUENT("6003007", "操作冲突"),
    /**
     * 草稿为空，不能确认订单
     */
    LIVE_ORDER_IS_NULL("6003008", "草稿为空，不能确认订单"),
    /**
     * 直播间不存在
     */
    LIVE_ROOM_EXIST_ERROR("60020001", "直播间不存在"),
    /**
     * 无此直播间权限
     */
    LIVE_ROOM_POWER_ERROR("60020002", "无此直播间权限"),
    /**
     * 直播间订单不存在
     */
    LIVE_ORDER_EXIST_ERROR("60020003", "直播间订单不存在"),
    /**
     * 参数异常
     */
    LIVE_CONFIRM_WORKER_ERROR("60020005", "参数异常"),
    /**
     * 直播间上麦准备应答冲突
     */
    LIVE_SERVING_WHEAT_RESP_ERROR("60020007", "直播间上麦准备应答冲突"),
    /**
     * 直播间订单未结束,不可切换下一订单
     */
    LIVE_ORDER_UNFINISHED_ERROR("60020008", "直播间订单未结束,不可切换下一订单"),
    /**
     * 订单已上麦,不可取消
     */
    LIVE_ORDER_CANCEL_ERROR("60020009", "订单已上麦,不可取消"),
    /**
     * 此订单不是您的订单,不可操作
     */
    EMPLOYER_LIVE_ORDER_EXIST_ERROR("60020010", "此订单不是您的订单,不可操作"),
    /**
     * 简易订单不可转为滴滴单
     */
    LIVE_SIMPLE_ORDER_CONVERT_DIDI_ERROR("60020011", "简易订单不可转为滴滴单"),
    /**
     * 订单已上麦,不可转为滴滴单
     */
    LIVE_ORDER_CANNOT_CONVERT_ERROR("60020012", "订单已上麦,不可转为滴滴单"),
    /**
     * 主持人未在线,不可发布订单,您可选择其他直播间发单
     */
    LIVE_COMPERE_OFFLINE_ERROR("60020013", "主持人未在线,不可发布订单,您可选择其他直播间发单"),
    /**
     * 暂无排队工人
     */
    LIVE_QUEUE_WORKER_EMPTY_ERROR("60020014", "暂无排队工人"),
    /**
     * 当前订单报价自荐名额已满
     */
    ORDER_OFFER_ONESELF_FULL_ERROR("60010008", "当前订单报价自荐名额已满"),
    /**
     * 操作失败，直播间还有未完成订单
     */
    COMPERE_OFF_WORK_FAILURE("60010009", "操作失败，直播间还有未完成订单"),
    /**
     * 直播间无排队订单
     */
    LIVE_NOT_QUEUE_ORDER("60010010", "直播间无排队订单"),

    /**
     * 订单未完善,不可操作流程
     */
    LIVE_ORDER_NOT_PERFECT("60010011", "订单未完善,不可操作流程"),
    /**
     * 你已被踢出，暂不可进入
     */
    KICK_OUT_LIVE("60010013", "你已被踢出，暂不可进入"),
    /**
     * 您已报价，不可重复操作
     */
    REPEAT_ONESELF_OFFER_MONEY("60010014", "您已报价，不可重复操作"),
    /**
     * 开播失败，已有主持人开播
     */
    ALREADY_ON_THE_AIR("60010015", "开播失败，已有主持人开播"),
    /**
     * 当前时间与该订单开工时间间隔小于30分钟
     */
    LIVER_ORDER_START_TIME_TIP("60010016", "当前时间与该订单开工时间间隔小于30分钟"),
    /**
     * 沒有可清除的消息
     */
    THERE_ARE_NO_CLEAR_MESSAGES("60010017", "沒有可清除的消息"),
    /**
     * 本房间人数已满，请从订单排队进入
     */
    LIVE_USER_NUM_LIMIT("60010018", "本房间人数已满，请从订单排队进入");


    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
