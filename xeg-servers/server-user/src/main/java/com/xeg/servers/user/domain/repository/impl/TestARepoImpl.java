package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.TestA;
import com.xeg.servers.user.domain.mapper.TestAMapper;
import com.xeg.servers.user.domain.repository.TestARepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-08
 */
@Service
public class TestARepoImpl extends ServiceImpl<TestAMapper, TestA> implements TestARepo {

}
