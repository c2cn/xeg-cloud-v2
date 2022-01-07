package com.xeg.cores.topic.rabbit;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author ningpeng
 * @Date
 */
public interface RabbitOutput {

    /**
     * 发送socket message
     *
     * @return
     */
    @Output(RabbitTopic.SEND_SOCKET_MESSAGE)
    MessageChannel sendSocketMessage();

    /**
     * 雇主支付倒计时处理剩余2分钟
     *
     * @return
     */
    @Output(RabbitTopic.EMPLOYER_PAY_END_TIME_LAST_2_MINUTE)
    MessageChannel sendEmployerPayEndTimeLast2Minute();

    /**
     * 雇主支付倒计时处理
     *
     * @return
     */
    @Output(RabbitTopic.EMPLOYER_PAY_END_TIME)
    MessageChannel sendEmployerPayEndTime();

    /**
     * 雇工支付倒计时
     *
     * @return
     */
    @Output(RabbitTopic.WORKER_PAY_END_TIME)
    MessageChannel sendWorkerPayEndTime();

    /**
     * 生成二维码
     *
     * @return
     */
    @Output(RabbitTopic.MAKE_INVITATION_QR_OUTPUT)
    MessageChannel makeInvitationQr();

    /**
     * 发送券活动
     *
     * @return
     */
    @Output(RabbitTopic.SEND_COUPON_ACTIVITY)
    MessageChannel sendCouponActivity();

    /**
     * 测试
     *
     * @return
     */
    @Output(RabbitTopic.SEND_MESSAGE_TEST_OUTPUT)
    MessageChannel sendMessageTest();

    /**
     * 招工倒计时处理最后2分钟
     *
     * @return
     */
    @Output(RabbitTopic.RECRUIT_COUNTDOWN_END_LAST_2_MINUTE)
    MessageChannel sendRecruitCountdownEndLast2Minute();

    /**
     * 招工倒计时处理
     *
     * @return
     */
    @Output(RabbitTopic.RECRUIT_COUNTDOWN_END)
    MessageChannel sendRecruitCountdownEnd();

    /**
     * 报价倒计时处理
     *
     * @return
     */
    @Output(RabbitTopic.OFFER_END_TIME)
    MessageChannel sendOfferEndTime();

    /**
     * 开工前2小时提醒
     *
     * @return
     */
    @Output(RabbitTopic.START_2_HOURS_AGO)
    MessageChannel sendStart2HoursAgoRemind();

    /**
     * 到达开工时间提醒1次可申请完工
     *
     * @return
     */
    @Output(RabbitTopic.START_ORDER)
    MessageChannel sendStartOrderRemind();

    /**
     * 完单分润
     * @return
     */
    @Output(RabbitTopic.FINISH_ORDER_TO_PROFIT_OUTPUT)
    MessageChannel finishOrderToProfit();

    /**
     * 增加代理邀请记录
     * @return
     */
    @Output(RabbitTopic.ADD_AGENT_INVITATION_USER_OUTPUT)
    MessageChannel addAgentInvitationUser();

    /**
     * 雇主上麦倒计时
     * @return
     */
    @Output(RabbitTopic.EMPLOYER_UP_WHEAT_END_TIME)
    MessageChannel sendEmployerUpWheatEndTime();

    /**
     * 雇工上麦倒计时
     * @return
     */
    @Output(RabbitTopic.WORKER_UP_WHEAT_END_TIME)
    MessageChannel sendWorkerUpWheatEndTime();

    /**
     * 雇工下麦倒计时
     * @return
     */
    @Output(RabbitTopic.WORKER_DOWN_WHEAT_END_TIME)
    MessageChannel sendWorkerDownWheatEndTime();


    /**
     * 给雇工推送消息
     *
     * @return
     */
    @Output(RabbitTopic.PUSH_WORKER_MSG)
    MessageChannel pushWorkerMsg();

    /**
     * 给雇主推送消息
     *
     * @return
     */
    @Output(RabbitTopic.PUSH_EMPLOYER_MSG)
    MessageChannel pushEmployerMsg();

    /**
     * 推送直播间消息
     *
     * @return
     */
    @Output(RabbitTopic.PUSH_LIVE_ROOM_MSG)
    MessageChannel pushLiveRoomMsg();

    /**
     * 延时解除禁言
     *
     * @return
     */
    @Output(RabbitTopic.REMOVE_MUTE_DELAY)
    MessageChannel removeMute();

    /**
     * 延时解除黑名单
     *
     * @return
     */
    @Output(RabbitTopic.REMOVE_BLACK_LIST_DELAY)
    MessageChannel removeRoomBlacklist();
}
