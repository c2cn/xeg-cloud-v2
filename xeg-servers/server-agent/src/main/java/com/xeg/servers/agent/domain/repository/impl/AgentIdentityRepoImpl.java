package com.xeg.servers.agent.domain.repository.impl;

import com.xeg.servers.agent.domain.entity.AgentIdentity;
import com.xeg.servers.agent.domain.mapper.AgentIdentityMapper;
import com.xeg.servers.agent.domain.repository.AgentIdentityRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户身份关联表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class AgentIdentityRepoImpl extends ServiceImpl<AgentIdentityMapper, AgentIdentity> implements AgentIdentityRepo {

}
