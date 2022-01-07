package com.xeg.cores.server.config;

import com.alibaba.csp.sentinel.SphU;
import com.alibaba.cloud.sentinel.feign.FunSentinelFeign;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @program: xeg-cloud
 * @description:
 * @author: ArchieDing
 * @create: 2021-05-12 12:51
 **/
@Configuration
public class FallbackConfig {

    @Bean
    @Scope("prototype")
    @ConditionalOnClass({SphU.class, Feign.class})
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    @Primary
    public Feign.Builder feignSentinelBuilder() {
        return FunSentinelFeign.builder();
    }
}
