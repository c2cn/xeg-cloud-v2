package com.xeg.devops.scheduler.executor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @program: xeg-cloud
 * @description:
 * @author: ArchieDing
 * @create: 2021-05-20 20:27
 **/
@Slf4j
public class HttpExecutorJob implements Job {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String serviceId = jobDataMap.getString("serviceId");
        String url = "http://" + serviceId + jobDataMap.getString("path");
        String method = jobDataMap.getString("method");
        String result = "";
        if ("GET".equalsIgnoreCase(method)) {
            result = restTemplate.getForObject(url, String.class);
        } else {
            String jsonArgs = jobDataMap.getString("jsonArgs");
            if (StrUtil.isNotEmpty(jsonArgs)) {
                JSON body = JSONUtil.parse(jsonArgs);
                result = restTemplate.postForObject(url, body, String.class);
            } else {
                result = restTemplate.postForObject(url, new HashMap<String, Object>(), String.class);
            }
        }
        context.setResult(result);
        log.info("{} {} result: {}", method, url, result);
    }
}
