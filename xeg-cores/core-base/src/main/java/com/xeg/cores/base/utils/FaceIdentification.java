package com.xeg.cores.base.utils;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ningpeng
 * @description: 人脸识别
 * @date 2021/8/6 14:20
 */
public class FaceIdentification {
    public static Double request(String url1,String url2){
        Map<String,Object> map= new HashMap<>();
        map.put("api_key", "aWA0ulOIPuJG3We99j2QnBdP-5iGpWPv");
        map.put("api_secret", "Gf-L-C00e0gDqSyeTeYZRvbHFce0vBEl");
        map.put("image_url1", url1);
        map.put("image_url2", url2);
        //构建请求
        String result = HttpRequest.post("https://api-cn.faceplusplus.com/facepp/v3/compare")
                .header(Header.CONTENT_TYPE, "multipart/form-data")
                .form(map)
                .timeout(3000)
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        Object confidence = jsonObject.get("confidence");
        if(null == confidence){
            return 0d;
        }
        return Double.valueOf(confidence.toString());
    }

    public static void main(String[] args) {
//        System.out.println(FaceIdentification.request("https://xeg.oss-cn-beijing.aliyuncs.com/xiaoergekeji/web/162823241384322.png","https://xeg.oss-cn-beijing.aliyuncs.com/xiaoergekeji/web/16282324181307.png"));
        System.out.println(FaceIdentification.request("http://xeg.oss-cn-beijing.aliyuncs.com/xiaoergekeji/app/face/C2205731279B2EB7BBA7BACA5AAC6BFA","http://xeg.oss-cn-beijing.aliyuncs.com/xiaoergekeji/app/idcard/4D68D23AC8327B4594AFFC9B49DD327A"));
    }
}
