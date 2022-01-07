package com.xeg.devops.gateway.config;

import com.xeg.devops.gateway.properties.ApiProperties;
import com.xeg.devops.gateway.properties.RequestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 预请求配置
 *
 * @author pangu
 */
@Configuration
@EnableConfigurationProperties({RequestProperties.class, ApiProperties.class})
public class PreRequestConfig {
}
