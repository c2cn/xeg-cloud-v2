package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.TestB;
import com.xeg.servers.user.domain.mapper.TestBMapper;
import com.xeg.servers.user.domain.repository.TestBRepo;
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
public class TestBRepoImpl extends ServiceImpl<TestBMapper, TestB> implements TestBRepo {

}
