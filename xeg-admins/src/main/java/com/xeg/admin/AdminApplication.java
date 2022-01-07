package com.xeg.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName：com.xiaoergekeji.applet
 * @ClassName：AppletApplication
 * @Description：启动类
 * @Author：xulp
 * @Date：2021/10/25 15:20
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xeg")
@SpringBootApplication(scanBasePackages = "com.xeg")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
