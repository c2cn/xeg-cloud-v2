package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.Test;
import com.xeg.servers.user.domain.mapper.TestMapper;
import com.xeg.servers.user.domain.repository.TestRepo;
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
public class TestRepoImpl extends ServiceImpl<TestMapper, Test> implements TestRepo {

}
