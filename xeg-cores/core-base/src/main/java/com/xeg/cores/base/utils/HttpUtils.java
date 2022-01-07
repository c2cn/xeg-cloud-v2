package com.xeg.cores.base.utils;

import cn.hutool.http.HttpUtil;
import com.xeg.cores.base.config.TencentCloudConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/6/28 16:51
 **/
@Component
@Slf4j
public class HttpUtils extends HttpUtil {

    @Resource
    private TencentCloudConfig tencentCloudConfig;

    /**
     * 发送post请求
     *
     * @param uri  地址
     * @param body 消息体
     * @return
     */
    public String doPostIm(String uri,String sig, String body) {
        String url = spliceUrl(uri,sig);
        log.warn("POST发送IM请求-->" + url);
        log.warn("body-->" + body);
        String post = HttpUtil.post(url, body);
        log.warn("响应-->" + post);
        return post;
    }

    /**
     * 发送get请求
     *
     * @param uri 地址
     * @return
     */
    public String doGetIm(String uri,String sig) {
        String url = this.spliceUrl(uri,sig);
        log.warn("GET发送IM请求-->" + url);
        String get = HttpUtil.get(url);
        log.warn("响应-->" + get);
        return get;
    }

    /**
     * 构建请求参数
     *
     * @param uri
     * @return
     */
    private String spliceUrl(String uri,String sig) {
        //构造请求头
        StringBuffer sb = new StringBuffer();
        sb.append("https://console.tim.qq.com/v4/")
                .append(uri)
                .append("?sdkappid=")
                .append(tencentCloudConfig.getSdkappid())
                .append("&usersig=")
                .append(sig)
                .append("&identifier="+tencentCloudConfig.getIdentifier())
                .append("&random=")
                .append(RandomUtils.randomInt())
                .append("&contenttype=json");
        return sb.toString();
    }
}
