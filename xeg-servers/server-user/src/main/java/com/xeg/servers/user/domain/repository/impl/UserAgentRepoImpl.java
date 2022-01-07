package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.UserAgent;
import com.xeg.servers.user.domain.mapper.UserAgentMapper;
import com.xeg.servers.user.domain.repository.UserAgentRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户上级代理关联表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class UserAgentRepoImpl extends ServiceImpl<UserAgentMapper, UserAgent> implements UserAgentRepo {

}
