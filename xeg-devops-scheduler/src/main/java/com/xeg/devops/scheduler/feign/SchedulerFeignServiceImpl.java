//package com.xiaoergekeji.devops.scheduler.feign;
//
//import com.xiaoergekeji.core.base.exception.ThrowCommonException;
//import com.xiaoergekeji.core.base.http.JsonResult;
//import com.xiaoergekeji.core.base.http.JsonResultUtils;
//import com.xiaoergekeji.core.base.http.PageVO;
//import com.xiaoergekeji.devops.scheduler.api.SchedulerFeignService;
//import com.xiaoergekeji.devops.scheduler.bean.dto.JobDTO;
//import com.xiaoergekeji.devops.scheduler.bean.qo.TaskLogQO;
//import com.xiaoergekeji.devops.scheduler.bean.vo.TaskInfoVO;
//import com.xiaoergekeji.devops.scheduler.bean.vo.TaskLogVO;
//import com.xiaoergekeji.devops.scheduler.service.SchedulerService;
//import com.xiaoergekeji.devops.scheduler.service.SchedulerTaskLogService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 00:18
// **/
//@Api(tags = "任务调度")
//@RestController
//@RequestMapping("/feign/scheduler")
//public class SchedulerFeignServiceImpl implements SchedulerFeignService {
//    @Autowired
//    private SchedulerService schedulerService;
//
//    @Autowired
//    private SchedulerTaskLogService schedulerTaskLogService;
//
//    @Override
//    @ApiOperation(value = "添加远程调度任务")
//    public JsonResult<Boolean> addJob(JobDTO dto) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getJobName(), "任务名称");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getExecutorType(), "执行器类型");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getServiceId(), "服务名称");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getPath(), "请求路径");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getMethod(), "请求方式");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getTriggerType(), "触发方式");
//
//        if ("cron".equals(dto.getTriggerType())) {
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getCronExpression(), "cron表达式");
//        } else if ("simple".equals(dto.getTriggerType())) {
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getStartTime(), "开始时间");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getEndTime(), "结束时间");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getRepeatInterval(), "重复间隔");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getRepeatCount(), "重复次数");
//        }
//        return JsonResultUtils.success(schedulerService.addJob(dto));
//    }
//
//    @Override
//    @ApiOperation(value = "修改远程调度任务")
//    public JsonResult<Boolean> editJob(JobDTO dto) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getJobName(), "任务名称");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getExecutorType(), "执行器类型");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getServiceId(), "服务名称");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getPath(), "请求路径");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getMethod(), "请求方式");
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getTriggerType(), "触发方式");
//
//        if ("cron".equals(dto.getTriggerType())) {
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getCronExpression(), "cron表达式");
//        } else if ("simple".equals(dto.getTriggerType())) {
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getStartTime(), "开始时间");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getEndTime(), "结束时间");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getRepeatInterval(), "重复间隔");
//            ThrowCommonException.ARG_IS_EMPTY.ifEmpty(dto.getRepeatCount(), "重复次数");
//        }
//        return JsonResultUtils.success(schedulerService.editJob(dto));
//    }
//
//    @Override
//    @ApiOperation(value = "删除远程调度任务")
//    public JsonResult<Boolean> deleteJob(String jobName) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(jobName, "任务名称");
//        return JsonResultUtils.success(schedulerService.deleteJob(jobName));
//    }
//
//    @Override
//    @ApiOperation(value = "开启远程调度任务")
//    public JsonResult<Boolean> startJob(String jobName) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(jobName, "任务名称");
//        return JsonResultUtils.success(schedulerService.startJob(jobName));
//    }
//
//    @Override
//    @ApiOperation(value = "暂停远程调度任务")
//    public JsonResult<Boolean> pauseJob(String jobName) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(jobName, "任务名称");
//        return JsonResultUtils.success(schedulerService.pauseJob(jobName));
//    }
//
//    @Override
//    @ApiOperation(value = "恢复远程调度任务")
//    public JsonResult<Boolean> resumeJob(String name) {
//        ThrowCommonException.ARG_IS_EMPTY.ifEmpty(name, "任务名称");
//        return JsonResultUtils.success(schedulerService.resumeJob(name));
//    }
//
//    @Override
//    @ApiOperation(value = "获取远程调度任务列表")
//    public JsonResult<List<TaskInfoVO>> getTaskInfoList() {
//        return JsonResultUtils.success(schedulerService.getTaskInfoList());
//    }
//
//    @Override
//    @ApiOperation(value = "获取远程调度任务日志列表")
//    public JsonResult<PageVO<TaskLogVO>> pageTaskLog(TaskLogQO qo) {
//        return JsonResultUtils.success(schedulerTaskLogService.pageTaskLog(qo));
//    }
//}
