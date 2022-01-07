package com.xeg.devops.gateway.config;

import com.xeg.devops.gateway.filter.SocketioLoadBalancerClientFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xeg-cloud
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-02 16:44
 **/
@Configuration
public class SocketioLoadBalancerClientConfig {
    @Bean
    @ConditionalOnMissingBean({SocketioLoadBalancerClientFilter.class})
    public SocketioLoadBalancerClientFilter socketioLoadBalancerClientFilter(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        return new SocketioLoadBalancerClientFilter(loadBalancer, properties);
    }
}
