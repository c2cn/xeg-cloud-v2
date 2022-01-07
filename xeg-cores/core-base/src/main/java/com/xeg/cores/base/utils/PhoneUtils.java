package com.xeg.cores.base.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/3 9:25
 **/
public class PhoneUtils {
    /**
     * 移动电话
     */
    public final static Pattern MOBILE = Pattern.compile("(?:0|86|\\+86)?1\\d{10}");

    /**
     * 验证是否为手机号码（中国）
     *
     * @param value 值
     * @return 是否为手机号码（中国）
     * @since 5.3.11
     */
    public static boolean isMobile(CharSequence value) {
        return Validator.isMatchRegex(MOBILE, value);
    }

    /**
     * 隐藏手机号前7位  替换字符为"*"
     * 栗子
     *
     * @param phone 手机号码
     * @return 替换后的字符串
     * @since 5.3.11
     */
    public static CharSequence hideBefore(CharSequence phone) {
        return StrUtil.hide(phone, 0, 7);
    }

    /**
     * 隐藏手机号中间4位  替换字符为"*"
     *
     * @param phone 手机号码
     * @return 替换后的字符串
     * @since 5.3.11
     */
    public static CharSequence hideBetween(CharSequence phone) {
        return StrUtil.hide(phone, 3, 7);
    }

    /**
     * 隐藏手机号最后4位  替换字符为"*"
     *
     * @param phone 手机号码
     * @return 替换后的字符串
     * @since 5.3.11
     */
    public static CharSequence hideAfter(CharSequence phone) {
        return StrUtil.hide(phone, 7, 11);
    }

    /**
     * 获取手机号前3位
     *
     * @param phone 手机号码
     * @return 手机号前3位
     * @since 5.3.11
     */
    public static CharSequence subBefore(CharSequence phone) {
        return StrUtil.sub(phone, 0, 3);
    }

    /**
     * 获取手机号中间4位
     *
     * @param phone 手机号码
     * @return 手机号中间4位
     * @since 5.3.11
     */
    public static CharSequence subBetween(CharSequence phone) {
        return StrUtil.sub(phone, 3, 7);
    }

    /**
     * 获取手机号后4位
     *
     * @param phone 手机号码
     * @return 手机号后4位
     * @since 5.3.11
     */
    public static CharSequence subAfter(CharSequence phone) {
        return StrUtil.sub(phone, 7, 11);
    }

    /**
     * 校验手机号一键登录
     *
     * @param phoneToken
     */
    public static String checkPhone(String phoneToken) {
        try {
            String appid = "300012066443";
            String version = "2.0";
            String msgid = RandomUtils.randomString(10);
            String systemtime = DateUtil.format(new Date(),"YYYYMMddHHmmssSSS");
            String strictcheck = "0";
            String appSecret = "C2A3DAA689144327A4944EC437DA2225";
            String sign = SecureUtil.md5(appid + version + msgid + systemtime + strictcheck + phoneToken + appSecret);

            JSONObject body = new JSONObject();
            body.set("version", version);
            body.set("msgid", msgid);
            body.set("systemtime", systemtime);
            body.set("strictcheck", strictcheck);
            body.set("appid", appid);
            body.set("token", phoneToken);
            body.set("sign", sign);
            body.set("encryptionalgorithm","");
            System.out.println(JSONUtil.toJsonStr(body));

            //构建请求
            String result = HttpRequest.post("https://onekey2.cmpassport.com/unisdk/rsapi/loginTokenValidate")
                    .header(Header.CONTENT_TYPE, "application/json")
                    .body(JSONUtil.toJsonStr(body))
                    .timeout(3000)
                    .execute().body();
            JSONObject jsonObject = JSONUtil.parseObj(result);
            String resultCode = jsonObject.getStr("resultCode");
            if (resultCode.equals("103000")) {
                return jsonObject.getStr("msisdn");
            }
            System.out.println("result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
//        System.out.println(checkPhone("15868804722", "STsid0000001628584360513ie2PTcfxoogSgG0wjT5c8OZJDii3fIX4"));
//        System.out.println(UUID.randomUUID().toString());
//        System.out.println(DateUtil.format(new Date(),"YYYYMMddHHmmssSSS"));
    }

}
