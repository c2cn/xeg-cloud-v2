package com.xeg.cores.topic.rabbit;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/6/24 17:22
 */
public class RabbitTopic {

    /**
     * 发送socket普通消息
     */
    public static final String SEND_SOCKET_MESSAGE = "send_socket_message";
    /**
     * 雇主支付倒计时
     */
    public static final String EMPLOYER_PAY_END_TIME = "employer_pay_end_time";
    /**
     * 雇主支付倒计时最后2分钟
     */
    public static final String EMPLOYER_PAY_END_TIME_LAST_2_MINUTE = "employer_pay_end_time_last_2_minute";
    /**
     * 生成邀请二维码
     */
    public static final String MAKE_INVITATION_QR_OUTPUT = "make_invitation_qr_output";
    /**
     * 生成邀请二维码
     */
    public static final String MAKE_INVITATION_QR_INPUT = "make_invitation_qr_input";
    /**
     * 雇工支付倒计时
     */
    public static final String WORKER_PAY_END_TIME = "worker_pay_end_time";
    /**
     * 测试
     */
    public static final String SEND_MESSAGE_TEST_OUTPUT = "send_message_test_output";
    /**
     * 测试
     */
    public static final String SEND_MESSAGE_TEST_INPUT = "send_message_test_input";
    /**
     * 发送券活动
     */
    public static final String SEND_COUPON_ACTIVITY = "send_coupon_activity";

    /**
     * 发送招工倒计时最后2分钟
     */
    public static final String RECRUIT_COUNTDOWN_END_LAST_2_MINUTE = "recruit_countdown_end_last_2_minute";

    /**
     * 发送招工倒计时
     */
    public static final String RECRUIT_COUNTDOWN_END = "recruit_countdown_end";

    /**
     * 报价倒计时
     */
    public static final String OFFER_END_TIME = "offer_end_time";

    /**
     * 开工前2小时提醒
     */
    public static final String START_2_HOURS_AGO = "start_2_hours_ago";

    /**
     * 到达开工时间提醒1次可申请完工
     */
    public static final String START_ORDER = "start_order";
    /**
     * 完单分润
     */
    public static final String FINISH_ORDER_TO_PROFIT_OUTPUT = "finish_order_to_profit_output";
    /**
     * 完单分润
     */
    public static final String FINISH_ORDER_TO_PROFIT_INPUT = "finish_order_to_profit_input";
    /**
     * 增加代理邀请记录
     */
    public static final String ADD_AGENT_INVITATION_USER_OUTPUT = "add_agent_invitation_user_output";
    /**
     * 增加代理邀请记录
     */
    public static final String ADD_AGENT_INVITATION_USER_INPUT = "add_agent_invitation_user_input";
    /**
     * 雇主上麦倒计时
     */
    public static final String EMPLOYER_UP_WHEAT_END_TIME = "employer_up_wheat_end_time";
    /**
     * 雇工上麦倒计时
     */
    public static final String WORKER_UP_WHEAT_END_TIME = "worker_up_wheat_end_time";
    /**
     * 雇工上麦倒计时
     */
    public static final String WORKER_DOWN_WHEAT_END_TIME = "worker_down_wheat_end_time";
    /**
     * 给雇工推送消息
     */
    public static final String PUSH_WORKER_MSG = "push_worker_msg";
    /**
     * 给雇主推送消息
     */
    public static final String PUSH_EMPLOYER_MSG = "push_employer_msg";
    /**
     * 推送直播间消息
     */
    public static final String PUSH_LIVE_ROOM_MSG = "push_live_room_msg";
    /**
     * 延时解除禁言
     */
    public static final String REMOVE_MUTE_DELAY = "remove_mute_delay";
    /**
     * 延时解除黑名单
     */
    public static final String REMOVE_BLACK_LIST_DELAY = "remove_black_list_delay";

}
