//package com.xiaoergekeji.devops.scheduler.listener;
//
//import com.xiaoergekeji.devops.scheduler.service.SchedulerTaskLogService;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 23:02
// **/
//@Slf4j
//@Component
//public class TaskLogListener implements JobListener {
//    @Autowired
//    private SchedulerTaskLogService schedulerTaskLogService;
//
//    @Override
//    public String getName() {
//        return "TaskLogListener";
//    }
//
//    @Override
//    public void jobToBeExecuted(JobExecutionContext context) {
//        log.debug("jobToBeExecuted: {}", context.getJobDetail().getKey().getName());
//    }
//
//    @Override
//    public void jobExecutionVetoed(JobExecutionContext context) {
//        log.debug("jobExecutionVetoed: {}", context.getJobDetail().getKey().getName());
//    }
//
//    @SneakyThrows
//    @Override
//    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
//        log.debug("jobWasExecuted: {}", context.getJobDetail().getKey().getName());
//        TaskLogDTO dto = new TaskLogDTO();
//        JobDetail jobDetail = context.getJobDetail();
//        dto.setJobName(jobDetail.getKey().getName());
//        dto.setJobDescription(jobDetail.getDescription());
//        Class<? extends Job> jobClass = jobDetail.getJobClass();
//        dto.setExecutorType(ExecutorMappingEnum.getType(jobClass));
//        dto.setFireTime(context.getFireTime().getTime());
//        dto.setJobRunTime(context.getJobRunTime());
//        dto.setFireEndTime(dto.getFireTime() + dto.getJobRunTime());
//        if (context.getPreviousFireTime() != null) {
//            dto.setPrevFireTime(context.getPreviousFireTime().getTime());
//        }
//        if (context.getNextFireTime() != null) {
//            dto.setNextFireTime(context.getNextFireTime().getTime());
//        }
//        Trigger trigger = context.getTrigger();
//        Trigger.TriggerState triggerState = context.getScheduler().getTriggerState(trigger.getKey());
//        dto.setJobStatus(triggerState.name());
//        if (trigger instanceof CronTrigger) {
//            dto.setTriggerType("cron");
//            CronTrigger cronTrigger = (CronTrigger) trigger;
//            dto.setCronExpression(cronTrigger.getCronExpression());
//
//        } else if (trigger instanceof SimpleTrigger) {
//            dto.setTriggerType("simple");
//            SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
//            dto.setTriggerStartTime(simpleTrigger.getStartTime().getTime());
//            if (simpleTrigger.getEndTime() != null) {
//                dto.setTriggerEndTime(simpleTrigger.getEndTime().getTime());
//            }
//            dto.setRepeatInterval(simpleTrigger.getRepeatInterval());
//            dto.setRepeatCount(simpleTrigger.getRepeatCount());
//        }
//        JobDataMap jobDataMap = context.getMergedJobDataMap();
//        dto.setServiceId(jobDataMap.getString("serviceId"));
//        dto.setPath(jobDataMap.getString("path"));
//        dto.setMethod(jobDataMap.getString("method"));
//        dto.setJsonArgs(jobDataMap.getString("jsonArgs"));
//        dto.setContentType(jobDataMap.getString("contentType"));
////        dto.setVersionCode(jobDataMap.getLong("versionCode"));
//        if (context.getResult() != null) {
//            dto.setJobResult((String) context.getResult());
//        }
//        if (jobException != null) {
//            dto.setJobException(jobException.getMessage());
//        }
//
//        schedulerTaskLogService.saveLog(dto);
//    }
//}
