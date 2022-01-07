package com.xeg.devops.scheduler.executor;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @program: xeg-cloud
 * @description:
 * @author: ArchieDing
 * @create: 2021-05-20 20:27
 **/
@Slf4j
public class TopicExecutorJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        log.debug(jobDataMap.getString("serviceId"));
    }
}
