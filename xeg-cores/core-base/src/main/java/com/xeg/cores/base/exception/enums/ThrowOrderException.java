package com.xeg.cores.base.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author xulp
 * @since 2021/11/02
 */
@Getter
@AllArgsConstructor
public enum ThrowOrderException {
    /**
     * 开工时间不得小于当前时间30分钟
     */
    START_WORK_TIME_ERROR("4002001", "开工时间不得小于当前时间30分钟"),
    /**
     * 工作年龄不符
     */
    WORK_AGE_ERROR("4002002", "工作年龄不符"),
    /**
     * 预算价格核算有误
     */
    WORK_MONEY_ERROR("4002003", "预算价格核算有误"),
    /**
     * 派单已结束
     */
    ORDER_DISPATCH_END_ERROR("4002004", "派单已结束"),
    /**
     * 订单状态不可跨越变更
     */
    ORDER_STATUS_OPERATION_ERROR("4002005", "订单状态不可跨越变更"),
    /**
     * 订单已被抢
     */
    ORDER_WORK_NUM_ERROR("4002007", "订单已被抢"),
    /**
     * 此订单无效
     */
    ORDER_VALID_ERROR("4002008", "此订单无效"),
    /**
     * 对方已提交订单结束申请
     */
    ORDER_END_APPLY_COMMITTED_ERROR("4002009", "对方已提交订单结束申请"),
    /**
     * 常用订单无可委派工人
     */
    ORDER_COMMON_WORKER_EXIST_ERROR("4002010", "常用订单无可委派工人"),
    /**
     * 此订单已抢过
     */
    ORDER_WORKER_ROB_ACCEPT_ERROR("4002011", "此订单已抢过"),
    /**
     * 此订单已议价
     */
    ORDER_WORKER_OFFER_ACCEPT_ERROR("4002012", "此订单已议价"),
    /**
     * 常用订单无可委派工人
     */
    ORDER_WORKER_ENTRUST_APPLY_ERROR("4002013", "未收到委托申请"),
    /**
     * 转委托订单次数已用完
     */
    ORDER_ENTRUST_COUNT_ERROR("4002014", "转委托订单次数已用完"),
    /**
     * 常用订单无可委派工人
     */
    ORDER_DIDI_COUNT_ERROR("4002015", "转滴滴订单次数已用完"),
    /**
     * 转议价订单次数已用完
     */
    ORDER_OFFER_COUNT_ERROR("4002016", "转议价订单次数已用完"),
    /**
     * 编辑重发次数已用完
     */
    ORDER_EDIT_COUNT_ERROR("4002017", "编辑重发次数已用完"),
    /**
     * 委托召集已结束
     */
    ENTRUST_CONVENE_END_ERROR("4002018", "委托召集已结束"),
    /**
     * 无发送召集单权限
     */
    WORKER_ENTRUST_POWER_ERROR("4002019", "无发送召集单权限"),
    /**
     * 派单进行中,请耐心等待
     */
    ORDER_DISPATCH_UNDERWAY_ERROR("4002020", "派单进行中,请耐心等待"),
    /**
     * 订单不存在
     */
    ORDER_EXIST_ERROR("4002021", "订单不存在"),
    /**
     * 订单不存在
     */
    WORKER_ORDER_EXIST_ERROR("4002022", "订单不存在"),
    /**
     * 无效的补救措施
     */
    ORDER_REPAIR_INVALID_ERROR("4002023", "无效的补救措施"),
    /**
     * 补救措施已失效
     */
    ORDER_REPAIR_EXIST_ERROR("4002024", "补救措施已失效"),
    /**
     * 工作时间冲突
     */
    ORDER_WORK_TIME_CONFLICT_ERROR("4002025", "工作时间冲突"),
    /**
     * 无效的订单结束申请
     */
    ORDER_END_APPLY_INVALID_ERROR("4002026", "无效的订单结束申请"),
    /**
     * 手机号码缺失或者区划编码缺失
     */
    ORDER_NO_GENERATOR_ERROR("4002027", "手机号码缺失或者区划编码缺失"),
    /**
     * 该订单已进行转单操作,请耐心等待派单结束
     */
    MEANWHILE_DISPATCH_CONVERT_ERROR("4002029", "该订单已进行转单操作,请耐心等待派单结束"),
    /**
     * 该订单人均价格低于平台最低标准,不允许发布
     */
    ORDER_PER_MONEY_ERROR("4002030", "该订单人均价格低于平台最低标准,不允许发布"),

    /**
     * 未到开工时间,不可申请完成订单
     */
    NOT_START_WORK_TIME_ERROR("4002031", "未到开工时间,不可申请完成订单"),
    /**
     * 订单已支付，不可取消
     */
    NOT_CANCEL_ORDER_ERROR("4002032", "订单已支付，不可取消"),
    /**
     * 已有人成单，不能停止
     */
    ORDER_DISPATCH_CONCLUDE_WORKER_ERROR("4002033", "已有人成单，不能停止"),
    /**
     * 派单已结束，不能停止
     */
    ORDER_DISPATCH_STATUS_ERROR("4002034", "派单已结束，不能停止"),
    /**
     * 拒绝倒计时结束，不允许提交投诉
     */
    ORDER_COMPLANINTS_ERROR("4002035", "拒绝倒计时结束，不允许提交投诉"),
    /**
     * 已投诉，不允许重复提交
     */
    ORDER_FEEDBACK_ERROR("4002036", "已投诉，不允许重复提交"),
    /**
     * 默认常用语，不允许删除
     */
    LANGUAGE_DEL_ERROR("4002037", "默认常用语，不允许删除"),
    /**
     * 常用语，不许超10条
     */
    LANGUAGE_SAVE_ERROR("4002038", "常用语，不许超10条"),
    /**
     * 抢单金额与原价不符
     */
    GENERAL_ROB_NO_ORIGINAL_PRICE("4002039", "抢单金额与原价不符"),
    /**
     * 当前已是手动模式
     */
    PRESENT_MANUAL_MODE("4002041", "当前已是手动模式"),
    /**
     * 参数异常
     */
    PARAMETER_ANOMALY("4002042", "参数异常"),
    /**
     * 你已成单，不可议价、抢单
     */
    ORDER_OFFER_GRAB_ERROR("4002043", "你已成单，不可议价、抢单"),
    /**
     * 对方未拒绝，不允许提交投诉
     */
    REJECTED_EMPTY_COMPLAINT_ERROR("4002044", "对方未拒绝，不允许提交投诉"),
    /**
     * 订单总金额不得超过99999
     */
    NOT_EXCEEDED_MAXIMUM_AMOUNT("4002045", "订单总金额不得超过99999"),
    /**
     * 工人订单统计信息不存在
     */
    WORKER_ORDER_STATISTICS_EXIST_ERROR("4002046", "工人订单统计信息不存在"),
    /**
     * 发单过于频繁，请稍后重试
     */
    ORDER_PUBLISH_LOCK_ERROR("4002047", "发单过于频繁，请稍后重试");


    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
