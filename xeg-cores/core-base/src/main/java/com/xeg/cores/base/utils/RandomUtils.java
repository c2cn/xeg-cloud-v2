package com.xeg.cores.base.utils;

import cn.hutool.core.util.RandomUtil;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/6/28 14:42
 **/
public class RandomUtils extends RandomUtil {

    /**
     * 用于随机选的字符,没有IOo
     */
    public static final String BASE_CHAR2 = "abcdefghijklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";

    /**
     * 用于随机选的字符和数字
     */
    public static final String BASE_CHAR_NUMBER2 = BASE_NUMBER + BASE_CHAR2;

    /**
     * 获得一个随机的字符串（只包含数字和字符,没有IOo）
     *
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomString(int length) {
        return randomString(BASE_CHAR_NUMBER2, length);
    }

}
