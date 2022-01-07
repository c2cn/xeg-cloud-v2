package com.xeg.devops.gateway.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author ningpeng
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "xeg.request")
public class RequestProperties {
    /**
     * 是否开启日志链路追踪
     */
    private Boolean trace = false;

    /**
     * 是否启用获取IP地址
     */
    private Boolean ip = false;

    /**
     * 是否启用黑名单模式
     */
    private Boolean enhance = true;
}

