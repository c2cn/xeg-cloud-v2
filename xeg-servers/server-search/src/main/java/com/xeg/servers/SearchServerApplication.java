package com.xeg.servers;

import java.io.IOException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

/**
 * @Description：启动类
 * @Author：xulp
 * @Date：2021/10/25 15:20
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.xeg")
public class SearchServerApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(SearchServerApplication.class, args);
        
    }
}
