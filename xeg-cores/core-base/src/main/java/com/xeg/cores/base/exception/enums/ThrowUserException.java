package com.xeg.cores.base.exception.enums;

import com.xeg.cores.base.exception.ServiceExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;



/**
 * @author xulp
 * @since 2021/11/02
 */
@Getter
@AllArgsConstructor
public enum ThrowUserException implements ServiceExceptionAssert {
    /**
     * 异地登录
     */
    TOKEN_ERROR("0000003", "异地登录"),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND("0000004", "用户不存在"),
    /**
     * 手机号码格式有误
     */
    PHONE_PATTERN_ERROR("0000006", "手机号码格式有误"),
    /**
     * 60秒内不可重复发送验证码
     */
    CODE_REPEAT_ERROR("0000007", "60秒内不可重复发送验证码"),
    /**
     * 当前验证码已失效
     */
    CODE_EXPIRE_ERROR("0000008", "当前验证码已失效"),
    /**
     * 验证码错误
     */
    CODE_ERROR("0000009", "验证码错误"),
    /**
     * 该手机号暂未注册
     */
    PHONE_NOT_FOUND_ERROR("0000010", "该手机号暂未注册"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR("0000011", "密码错误"),
    /**
     * 该手机号已注册
     */
    PHONE_REGISTRY_ERROR("0000012", "该手机号已注册"),
    /**
     * 旧密码错误
     */
    OLD_PASSWORD_ERROR("0000013", "旧密码错误"),
    /**
     * 邀请码错误
     */
    INVITE_CODE_ERROR("0000014", "邀请码错误"),
    /**
     * 该手机号已被禁用
     */
    PHONE_IS_BLACK_ERROR("0000015", "该手机号已被禁用"),
    /**
     * 昵称长度不能超过6位
     */
    NICKNAME_LENGTH_ERROR("0000016", "昵称长度不能超过6位"),
    /**
     * 您已提交举报
     */
    RESEND_REPORT_ERROR("0000017", "您已提交举报"),
    /**
     * 该用户已被冻结
     */
    USER_FREEZE_ERROR("0000101", "该用户已被冻结"),
    /**
     * 该用户已被禁用
     */
    USER_DISABLE_ERROR("0000102", "该用户已被禁用"),
    /**
     * 工人信息不存在
     */
    WORKER_ERROR("1000001", "工人信息不存在"),
    /**
     * 工人已下工
     */
    WORKER_OFFLINE_ERROR("1000002", "工人已下工"),
    /**
     * 超出订单派送距离
     */
    WORKER_BEYOND_ORDER_DISPATCH_ERROR("1000003", "超出订单派送距离"),
    /**
     * 性别不符
     */
    WORKER_SEX_ERROR("1000004", "性别不符"),
    /**
     * 已过开工时间
     */
    START_WORK_TIME_OVER_ERROR("1000005", "已过开工时间");

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
