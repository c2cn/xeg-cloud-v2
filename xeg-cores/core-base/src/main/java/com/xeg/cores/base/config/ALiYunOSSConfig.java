package com.xeg.cores.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Description 阿里云OSS配置
 * @Author Zhongkun Zhang
 * @Date 2021/5/28 11:49
 * @Version 1.0
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "aliyun")
public class ALiYunOSSConfig {

    /**
     * 一级代理二维码域名
     */
    private String qrCodeDomainNameFirst;
    /**
     * 二级代理二维码域名
     */
    private String qrCodeDomainNameSecond;
    /**
     * 用户二维码域名
     */
    private String qrCodeDomainNameUser;
    /**
     * 二维码存储OSS路径
     */
    private String qrFilePath;
    /**
     * 二维码长
     */
    private Integer qrHeight;
    /**
     * 二维码宽
     */
    private Integer qrWidth;
    /**
     * 二维码图片格式
     */
    private String qrFormat;
}
