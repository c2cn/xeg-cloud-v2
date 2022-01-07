package com.xeg.cores.base.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author xulp
 * @since 2021/11/02
 */
@Getter
@AllArgsConstructor
public enum ThrowPayException {
    /**
     * 支付失败
     */
    PAY_ERROR("3001001", "支付失败"),
    /**
     * 当前价格不能小于区域参数
     */
    PRICE_ERROR("3003002", "当前价格不能小于区域参数"),
    /**
     * 自荐报价最多只允许10人
     */
    ONESELF_OFFER_MAX_ERROR("3003004", "自荐报价最多只允许10人"),
    /**
     * 保证金不足
     */
    DEPOSIT_EXIST_ERROR("3002002", "保证金不足"),
    /**
     * 保证金明细不存在
     */
    DEPOSIT_DETAIL_EXIST_ERROR("3002003", "保证金明细不存在"),
    /**
     * 服务费超出保证金金额
     */
    SERVICE_FEE_AMOUNT_EXCESS_ERROR("3002004", "服务费超出保证金金额"),
    /**
     * 释放议价保证金失败
     */
    RELEASE_OFFER_DEPOSIT_ERROR("3002008", "释放议价保证金失败"),
    /**
     * 当前地区无工人
     */
    AREA_DEPOSIT_NULL("3002009", "当前地区无工人"),
    /**
     * 购买的手机号不能为空
     */
    BUY_PHONE_NUMBER_EMPTY_ERROR("3002010", "购买的手机号不能为空");


    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
