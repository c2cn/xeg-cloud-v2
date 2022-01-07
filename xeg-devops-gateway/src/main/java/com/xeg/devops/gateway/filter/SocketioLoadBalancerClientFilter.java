package com.xeg.devops.gateway.filter;


import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

/**
 * @program: xeg-cloud
 * @description:
 * @author: Archie Ding
 * @create: 2021-06-02 08:01
 **/
@Component
public class SocketioLoadBalancerClientFilter extends LoadBalancerClientFilter {


    public SocketioLoadBalancerClientFilter(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        super(loadBalancer, properties);
    }

    @Override
    protected ServiceInstance choose(ServerWebExchange exchange) {
        ServiceInstance serviceInstance = super.choose(exchange);
        if (null != serviceInstance && "app-socket".equals(serviceInstance.getServiceId()) &&
                exchange.getRequest().getPath().toString().contains("/socket.io/")) {
            Map<String, String> metadata = serviceInstance.getMetadata();
            String socketPort = metadata.getOrDefault("socket.port", "9099");
            int port = Integer.parseInt(socketPort);
            return new DefaultServiceInstance(serviceInstance.getInstanceId(), serviceInstance.getHost(), port, serviceInstance.isSecure());
        }
        return serviceInstance;
    }
}
