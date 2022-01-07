//package com.xiaoergekeji.devops.scheduler.config;
//
//import com.xiaoergekeji.devops.scheduler.listener.TaskLogListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 23:01
// **/
//@Configuration
//public class SchedulerConfig implements SchedulerFactoryBeanCustomizer {
//    @Autowired
//    private TaskLogListener taskLogListener;
//
//    @Override
//    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
//        schedulerFactoryBean.setStartupDelay(5);
//        schedulerFactoryBean.setAutoStartup(true);
//        schedulerFactoryBean.setOverwriteExistingJobs(true);
//        schedulerFactoryBean.setGlobalJobListeners(taskLogListener);
//    }
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//}
