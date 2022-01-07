package com.xeg.cores.base.utils;

import cn.hutool.crypto.SecureUtil;

import java.math.BigDecimal;

/**
 * @author ningpeng
 * @description: 小二哥支付工具类
 * @date 2021/6/15 14:04
 */
public class XegPayUtils {
    /**
     * 获取Sign
     *
     * @param tradeOrderNo
     * @param totalAmount
     * @param returnUrl
     * @return
     */
    public static String getSign(String tradeOrderNo, BigDecimal totalAmount, String returnUrl) {
        StringBuffer str = new StringBuffer();
        str.append(tradeOrderNo).append(totalAmount).append(returnUrl);
        return SecureUtil.sha1(str.toString());
    }

    /**
     * 获取支付信息
     *
     * @param tradeOrderNo
     * @param totalAmount
     * @param returnUrl
     * @param sign
     * @return
     */
    public static String getPayInfo(String tradeOrderNo, BigDecimal totalAmount, String returnUrl, String sign) {
        StringBuffer payInfo = new StringBuffer();
        payInfo.append("tradeOrderNo").append("=").append(tradeOrderNo);
        payInfo.append("&");
        payInfo.append("totalAmount").append("=").append(totalAmount);
        payInfo.append("&");
        payInfo.append("returnUrl").append("=").append(returnUrl);
        payInfo.append("&");
        payInfo.append("sign").append("=").append(sign);
        return payInfo.toString();
    }
}
