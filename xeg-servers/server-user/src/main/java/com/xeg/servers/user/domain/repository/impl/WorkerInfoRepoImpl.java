package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.WorkerInfo;
import com.xeg.servers.user.domain.mapper.WorkerInfoMapper;
import com.xeg.servers.user.domain.repository.WorkerInfoRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工人表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class WorkerInfoRepoImpl extends ServiceImpl<WorkerInfoMapper, WorkerInfo> implements WorkerInfoRepo {

}
