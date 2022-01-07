package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.UserInfo;
import com.xeg.servers.user.domain.mapper.UserInfoMapper;
import com.xeg.servers.user.domain.repository.UserInfoRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-03
 */
@Service
public class UserInfoRepoImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoRepo {

}
