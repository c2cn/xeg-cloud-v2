//package com.xiaoergekeji.devops.scheduler.service;
//
//import com.xiaoergekeji.core.base.exception.ServiceException;
//import com.xiaoergekeji.core.base.exception.ThrowCommonException;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.dto.JobDTO;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.enums.TriggerTypeEnum;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.vo.TaskInfoVO;
//import com.xiaoergekeji.devops.scheduler.executor.ExecutorMappingEnum;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.quartz.impl.matchers.GroupMatcher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 20:17
// **/
//@Slf4j
//@Service
//public class SchedulerService {
//    @Autowired
//    private Scheduler scheduler;
//
//    public boolean addJob(JobDTO dto) {
//        try {
//            TriggerKey triggerKey = TriggerKey.triggerKey(dto.getJobName());
//            JobKey jobKey = JobKey.jobKey(dto.getJobName());
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (isExists) {
//                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
//                JobDataMap jobDataMap = jobDetail.getJobDataMap();
//                long versionCode = jobDataMap.getLong("versionCode");
//                if (dto.getVersionCode() > versionCode) {
//                    scheduler.pauseTrigger(triggerKey);
//                    scheduler.unscheduleJob(triggerKey);
//                } else {
//                    return true;
//                }
//            }
//            JobDataMap jobDataMap = new JobDataMap();
//            jobDataMap.put("serviceId", dto.getServiceId());
//            jobDataMap.put("path", dto.getPath());
//            jobDataMap.put("method", dto.getMethod());
//            jobDataMap.put("jsonArgs", dto.getJsonArgs());
//            jobDataMap.put("contentType", dto.getContentType());
//            jobDataMap.put("versionCode", dto.getVersionCode());
//            Class<? extends Job> jobClass = ExecutorMappingEnum.getClazz(dto.getExecutorType());
//            JobDetail jobDetail = JobBuilder.newJob(jobClass)
//                    .withIdentity(jobKey)
//                    .withDescription(dto.getDescription())
//                    .usingJobData(jobDataMap)
//                    .build();
//
//            if (TriggerTypeEnum.CRON.getValue().equals(dto.getTriggerType())) {
//                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(dto.getCronExpression())
//                        .withMisfireHandlingInstructionDoNothing();
//                CronTrigger cronTrigger = TriggerBuilder.newTrigger()
//                        .withIdentity(triggerKey)
//                        .withSchedule(cronScheduleBuilder)
//                        .build();
//                scheduler.scheduleJob(jobDetail, cronTrigger);
//            } else {
//                SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInMilliseconds(dto.getRepeatInterval())
//                        .withRepeatCount(dto.getRepeatCount());
//                SimpleTrigger simpleTrigger = TriggerBuilder
//                        .newTrigger()
//                        .withIdentity(triggerKey)
//                        .startAt(new Date(dto.getStartTime()))
//                        .withSchedule(simpleScheduleBuilder)
//                        .endAt(new Date(dto.getEndTime()))
//                        .build();
//                scheduler.scheduleJob(jobDetail, simpleTrigger);
//            }
//            return true;
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "添加远程调度任务失败");
//        }
//    }
//
//    public boolean editJob(JobDTO dto) {
//        try {
//            JobKey jobKey = JobKey.jobKey(dto.getJobName());
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (isExists) {
//                TriggerKey triggerKey = TriggerKey.triggerKey(dto.getJobName());
//                scheduler.pauseTrigger(triggerKey);
//                scheduler.unscheduleJob(triggerKey);
//            }
//            return this.addJob(dto);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "修改远程调度任务失败");
//        }
//    }
//
//    public boolean deleteJob(String jobName) {
//        try {
//            JobKey jobKey = JobKey.jobKey(jobName);
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (!isExists) {
//                return true;
//            }
//            TriggerKey triggerKey = TriggerKey.triggerKey(jobName);
//            scheduler.pauseTrigger(triggerKey);
//            scheduler.unscheduleJob(triggerKey);
//            return true;
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "删除远程调度任务失败");
//        }
//    }
//
//    public boolean startJob(String jobName) {
//        try {
//            JobKey jobKey = JobKey.jobKey(jobName);
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (!isExists) {
//                throw new ServiceException(ThrowCommonException.ANY_ERROR, "远程调度任务不存在");
//            }
//            scheduler.triggerJob(jobKey);
//            return true;
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "删除远程调度任务失败");
//        }
//    }
//
//    public boolean pauseJob(String jobName) {
//        try {
//            JobKey jobKey = JobKey.jobKey(jobName);
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (!isExists) {
//                throw new ServiceException(ThrowCommonException.ANY_ERROR, "远程调度任务不存在");
//            }
//            TriggerKey triggerKey = TriggerKey.triggerKey(jobName);
//            scheduler.pauseTrigger(triggerKey);
//            return true;
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "删除远程调度任务失败");
//        }
//    }
//
//    public boolean resumeJob(String jobName) {
//        try {
//            JobKey jobKey = JobKey.jobKey(jobName);
//            boolean isExists = scheduler.checkExists(jobKey);
//            if (!isExists) {
//                throw new ServiceException(ThrowCommonException.ANY_ERROR, "远程调度任务不存在");
//            }
//            TriggerKey triggerKey = TriggerKey.triggerKey(jobName);
//            scheduler.resumeTrigger(triggerKey);
//            return true;
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "删除远程调度任务失败");
//        }
//    }
//
//    public List<TaskInfoVO> getTaskInfoList() {
//        List<TaskInfoVO> list = new ArrayList<>();
//        try {
//            Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyGroup());
//            for (JobKey jobKey : jobKeys) {
//                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
//                List<? extends Trigger> triggersOfJob = scheduler.getTriggersOfJob(jobKey);
//                for (Trigger trigger : triggersOfJob) {
//                    TaskInfoVO taskInfoVO = new TaskInfoVO();
//                    taskInfoVO.setJobName(jobKey.getName());
//                    taskInfoVO.setDescription(jobDetail.getDescription());
//                    taskInfoVO.setExecutorType(ExecutorMappingEnum.getType(jobDetail.getJobClass()));
//
//                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
//                    taskInfoVO.setJobStatus(triggerState.name());
//                    if (trigger instanceof CronTrigger) {
//                        taskInfoVO.setTriggerType(TriggerTypeEnum.CRON.getValue());
//                        CronTrigger cronTrigger = (CronTrigger) trigger;
//                        taskInfoVO.setCronExpression(cronTrigger.getCronExpression());
//                    } else if (trigger instanceof SimpleTrigger) {
//                        taskInfoVO.setTriggerType(TriggerTypeEnum.SIMPLE.getValue());
//                        SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
//                        taskInfoVO.setRepeatInterval(simpleTrigger.getRepeatInterval());
//                        taskInfoVO.setRepeatCount(simpleTrigger.getRepeatCount());
//                        taskInfoVO.setStartTime(simpleTrigger.getStartTime().getTime());
//                        if (simpleTrigger.getEndTime() != null) {
//                            taskInfoVO.setEndTime(simpleTrigger.getEndTime().getTime());
//                        }
//                    }
//
//                    JobDataMap jobDataMap = jobDetail.getJobDataMap();
//                    taskInfoVO.setServiceId(jobDataMap.getString("serviceId"));
//                    taskInfoVO.setPath(jobDataMap.getString("path"));
//                    taskInfoVO.setMethod(jobDataMap.getString("method"));
//                    taskInfoVO.setJsonArgs(jobDataMap.getString("jsonArgs"));
//                    taskInfoVO.setContentType(jobDataMap.getString("contentType"));
//                    taskInfoVO.setVersionCode(jobDataMap.getLong("versionCode"));
//                    list.add(taskInfoVO);
//                }
//            }
//
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw new ServiceException(ThrowCommonException.ANY_ERROR, "获取远程调度任务列表失败");
//        }
//        return list;
//    }
//}
