package com.xeg.servers.user.domain.repository.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xeg.servers.user.domain.entity.TestBaseDO;
import com.xeg.servers.user.domain.mapper.TestBaseMapper;
import com.xeg.servers.user.domain.repository.TestBaseRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestBaseRepoImpl extends ServiceImpl<TestBaseMapper, TestBaseDO> implements TestBaseRepo {
	
}
