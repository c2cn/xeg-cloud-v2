package com.xeg.cores.base.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ningpeng
 * @description: 身份认证
 * @date 2021/7/13 18:47
 */
public class RealNameUtils {
    /**
     * @param identityCard
     * @param realName
     */
    public static boolean realName(String identityCard, String realName) {
        String host = "https://zid.market.alicloudapi.com";
        String path = "/idcard/VerifyIdcardv2";
        String appcode = "d580684c1e744e0da039bd78c2f27441";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, Object> querys = new HashMap<String, Object>();
        querys.put("cardNo", identityCard);
        querys.put("realName", realName);


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpRequest httpRequest = HttpUtil.createGet(host + path).form(querys).addHeaders(headers);
            HttpResponse httpResponse = httpRequest.execute();
            String body = httpResponse.body();
            System.out.println(body);
            JSONObject jsonObject = JSONUtil.parseObj(body);
            String result = jsonObject.getStr("result");
            JSONObject jsonObjectResult = JSONUtil.parseObj(result);
            return jsonObjectResult.getBool("isok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
