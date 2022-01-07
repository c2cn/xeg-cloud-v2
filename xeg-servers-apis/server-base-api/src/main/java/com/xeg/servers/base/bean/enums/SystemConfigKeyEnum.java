package com.xeg.servers.base.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 系统配置Key枚举
 * @Author xulp
 * @Date 2020/9/25 11:10
 */
@Getter
@AllArgsConstructor
public enum SystemConfigKeyEnum {
    FEED_BACK_TYPE("意见反馈类型 1 投诉 2建议 3故障 4其他", "feedbackType"),
    FEED_BACK_NUM("意见反馈时图片数量以及视频数量", "feedbackNum"),
    ORDER_AGE("年龄区间", "orderAge"),
    ORDER_INSPECTION("考核重点", "orderInspection"),
    ORDER_WELFARE("福利待遇", "orderWelfare"),
    ORDER_VOICE("语音时长最大值", "orderVoice"),
    ORDER_START_WORK_TIME("距离开工时间", "orderStartWorkTime"),
    NEARBY_WORKER_DISTANCE("附近工人扫描距离", "nearbyWorkerDistance"),
    CREDIT_SCORE("信用驾照默认分,", "creditScore"),
    WORKER_HEAD("工人默认头像", "workerHead"),
    EMPLOYER_HEAD("雇主默认头像", "employerHead"),
    ORDER_REPAIR_DURATION("订单补救措施延时时长,", "orderRepairDuration"),
    ORDER_MIN_PRE_MONEY("最低发单门槛", "minPreMoney"),
    APPLY_ORDER_END_TASK("申请完成订单定时任务调度", "applyOrderEndTask"),
    BUS_ORDER_INDEX_DISTANCE("短工大厅附近距离,", "busOrderIndexDistance"),
    BUS_ORDER_START_WORK_TIME("短期工距离开工时间", "busOrderStartWorkTime"),
    BUS_PHRASES_NUMBER("短工大厅系统常用语条数限制", "busPhrasesNumber"),
    NOTICE_BUY_PHONE("短工购买手机号支付金额", "noticeBuyPhone"),
    NOTICE_SWIFT_MSG_RESET_TIME("短工快捷消息发送重置时间 单位：秒", "noticeSwiftMsgResetTime"),
    ORDER_AUTO_EVALUATE_TIME("订单完成后自动评价时间 单位：秒","orderAutoEvaluateTime"),
    ORDER_APPLY_REJECTED_TIME("申请完成订单被拒绝后冷却时间 单位：秒", "busOrderRejections"),
    ORDER_UNPAY_CANCEL_TIME("未支付订单自动取消时间", "busOrderPayTime")
    ;

    private final String name;
    private final String value;

}
