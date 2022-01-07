package com.xeg.servers.agent.domain.repository.impl;

import com.xeg.servers.agent.domain.entity.AgentInfo;
import com.xeg.servers.agent.domain.mapper.AgentInfoMapper;
import com.xeg.servers.agent.domain.repository.AgentInfoRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代理商信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class AgentInfoRepoImpl extends ServiceImpl<AgentInfoMapper, AgentInfo> implements AgentInfoRepo {

}
