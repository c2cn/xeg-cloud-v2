package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.UserToken;
import com.xeg.servers.user.domain.mapper.UserTokenMapper;
import com.xeg.servers.user.domain.repository.UserTokenRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户token表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class UserTokenRepoImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenRepo {

}
