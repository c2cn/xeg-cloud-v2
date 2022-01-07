package com.xeg.cores.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Description 腾讯云配置
 * @Author Zhongkun Zhang
 * @Date 2021/8/8 11:49
 * @Version 1.0
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "tencent")
public class TencentCloudConfig {

    /**
     * IM的sdkappid
     */
    private Long sdkappid;

    /**
     * IM的key
     */
    private String imKey;

    /**
     * 音视频的sdkappid
     */
    private Long sdkMVAppId;

    /**
     * 音视频的key
     */
    private String mvKey;

    /**
     * 马小丫ID
     */
    private String identifier;

    /**
     * 马小丫名字
     */
    private String maXiaoYaName;

    /**
     * 马小丫头像地址
     */
    private String maXiaoYaAvatar;

}
