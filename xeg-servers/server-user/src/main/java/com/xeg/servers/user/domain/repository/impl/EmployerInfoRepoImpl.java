package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.EmployerInfo;
import com.xeg.servers.user.domain.mapper.EmployerInfoMapper;
import com.xeg.servers.user.domain.repository.EmployerInfoRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表(雇主) 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class EmployerInfoRepoImpl extends ServiceImpl<EmployerInfoMapper, EmployerInfo> implements EmployerInfoRepo {

}
