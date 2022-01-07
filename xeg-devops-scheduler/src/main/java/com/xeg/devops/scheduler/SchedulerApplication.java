package com.xeg.devops.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description //TODO
 * @Author Qi Ding
 * @Date 2021/3/16 4:13 下午
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.xeg")
public class SchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }
}
