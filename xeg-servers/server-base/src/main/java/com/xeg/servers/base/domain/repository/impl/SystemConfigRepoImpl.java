package com.xeg.servers.base.domain.repository.impl;

import com.xeg.servers.base.domain.entity.SystemConfig;
import com.xeg.servers.base.domain.mapper.SystemConfigMapper;
import com.xeg.servers.base.domain.repository.SystemConfigRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class SystemConfigRepoImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigRepo {

}
