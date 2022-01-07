package com.xeg.servers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description：启动类
 * @Author：xulp
 * @Date：2021/10/25 15:20
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xeg")
@SpringBootApplication(scanBasePackages = "com.xeg")
public class PushServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PushServerApplication.class, args);
    }
}
