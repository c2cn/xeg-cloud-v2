package com.xeg.servers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description：启动类
 * @Author：xulp
 * @Date：2021/10/25 15:20
 */
@EnableDiscoveryClient
@MapperScan("com.xeg.servers.**.mapper")
@EnableFeignClients(basePackages = "com.xeg")
@SpringBootApplication(scanBasePackages = "com.xeg", exclude = JtaAutoConfiguration.class)
public class UserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
