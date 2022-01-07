//package com.xiaoergekeji.devops.scheduler.service;
//
//import cn.hutool.core.util.ObjectUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.xiaoergekeji.core.mysql.PageUtils;
//import com.xiaoergekeji.core.base.http.PageVO;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.dto.TaskLogDTO;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.qo.TaskLogQO;
//import com.xiaoergekeji.devops.gateway.scheduler.bean.vo.TaskLogVO;
//import com.xiaoergekeji.devops.gateway.scheduler.domain.entity.SchedulerTaskLog;
//import com.xiaoergekeji.devops.scheduler.bean.repository.SchedulerTaskLogRepo;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 23:02
// **/
//@Service
//public class SchedulerTaskLogService {
//    @Autowired
//    private SchedulerTaskLogRepo schedulerTaskLogRepo;
//
//    public void saveLog(TaskLogDTO dto) {
//        SchedulerTaskLog log = new SchedulerTaskLog();
//        BeanUtils.copyProperties(dto, log);
//        schedulerTaskLogRepo.save(log);
//    }
//
//    public PageVO<TaskLogVO> pageTaskLog(TaskLogQO qo) {
//        IPage<SchedulerTaskLog> pageQuery = new Page<>(qo.getPageNum(), qo.getPageSize());
//        QueryWrapper<SchedulerTaskLog> wrapper = new QueryWrapper<>();
//        wrapper.eq(ObjectUtil.isNotEmpty(qo.getJobName()), "job_name", qo.getJobName())
//                .eq(ObjectUtil.isNotEmpty(qo.getServiceId()), "service_id", qo.getServiceId())
//                .ge(ObjectUtil.isNotEmpty(qo.getStartTime()), "create_time", qo.getStartTime())
//                .le(ObjectUtil.isNotEmpty(qo.getEndTime()), "create_time", qo.getEndTime())
//                .orderByDesc("create_time");
//        IPage<SchedulerTaskLog> list = schedulerTaskLogRepo.page(pageQuery, wrapper);
//        return PageUtils.convert(list, SchedulerTaskLog.class, TaskLogVO.class);
//    }
//}
