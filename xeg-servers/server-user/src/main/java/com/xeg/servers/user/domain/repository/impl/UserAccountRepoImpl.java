package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.UserAccount;
import com.xeg.servers.user.domain.mapper.UserAccountMapper;
import com.xeg.servers.user.domain.repository.UserAccountRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class UserAccountRepoImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountRepo {

}
