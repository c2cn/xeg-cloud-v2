package com.xeg.cores.base.utils;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 发送钉钉消息工具类
 * @author: Zhongkun Zhang
 * @create: 2021/7/1 18:40
 **/
@Slf4j
public class DingDingSendMasUtils {

    /**
     * 发送钉钉消息
     *
     * @param url
     * @param jsonStr
     * @return
     */
    public static String send(String url, String jsonStr) {
        String result = HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, "application/json; charset=utf-8")
                .body(jsonStr)
                .timeout(3000)
                .execute().body();
        return result;
    }
}
