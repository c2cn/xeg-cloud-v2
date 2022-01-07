package com.xeg.servers.pay.domain.repository.impl;

import java.math.BigDecimal;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xeg.servers.pay.domain.entity.PaycallbackFailRecord;
import com.xeg.servers.pay.domain.mapper.PaycallbackFailRecordMapper;
import com.xeg.servers.pay.domain.repository.PaycallbackFailRecordRepo;
import com.xeg.servers.user.domain.entity.TestA;
import com.xeg.servers.user.domain.entity.TestB;
import com.xeg.servers.user.domain.mapper.TestAMapper;
import com.xeg.servers.user.domain.repository.TestBRepo;

import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年11月4日 下午2:08:23
	* @version v1.0.0
	* @Description	支付回调失败记录表 服务实现类
	* PaycallbackFailRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午2:08:23       xian            v1.0.0           Created
 */

@Slf4j
@Service
public class PaycallbackFailRecordRepoImpl extends 
	ServiceImpl<PaycallbackFailRecordMapper, PaycallbackFailRecord> implements PaycallbackFailRecordRepo {
	@Autowired
	private PaycallbackFailRecordMapper paycallbackFailRecordMapper;
	
	@Autowired
	private TestAMapper testAMapper;
	
	@Autowired
	private TestBRepo testBRepo;
	
	@Override
	@ShardingTransactionType(value = TransactionType.XA)
	@Transactional(rollbackFor = Exception.class)
	public PaycallbackFailRecord getPayCallBackResult(String orderNo, int uid, int sceneType) {
		log.info("getPayCallBackResult...");
		
		// 查询条件
		QueryWrapper<PaycallbackFailRecord> queryWrapper = new QueryWrapper<PaycallbackFailRecord>();
		queryWrapper.eq("uid", uid).eq("order_no", orderNo).eq("scene_type", sceneType).eq("is_del", 0);
		
		PaycallbackFailRecord paycallbackFailRecord = paycallbackFailRecordMapper.selectOne(queryWrapper);
		log.info("paycallbackFailRecord = " + JSON.toJSONString(paycallbackFailRecord));
		
//		log.info("testUpdateA...");
//		testAMapper.testUpdateA(2L, BigDecimal.valueOf(10D));
//		
//		log.info("selectTestA...");
//		TestA testA = testAMapper.selectTestA(2L);
//		log.info("testA = " + JSON.toJSONString(testA));
//		
//		log.info("insertTestB...");
//		TestB testB = new TestB();
//		testB.setUserId(testA.getUserId());
//		testB.setUserName(testA.getUserName());
//		testB.setAmount(BigDecimal.valueOf(10D));
//		testB.setBalance(testA.getBalance());
//		testBRepo.save(testB);
		
//		log.info("testSelectInsert1...");
//		paycallbackFailRecordMapper.testSelectInsert();
//		
//		log.info("testSelectInsert2...");
//		paycallbackFailRecordMapper.testSelectInsert2();
//		
//		log.info("testSelectInsert3...");
//		paycallbackFailRecordMapper.testSelectInsert3();
		
		return paycallbackFailRecord;
	}

}
