package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusDidiOrderAnswerWrongRecord;
import com.xeg.servers.order.domain.mapper.BusDidiOrderAnswerWrongRecordMapper;
import com.xeg.servers.order.domain.repository.BusDidiOrderAnswerWrongRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 滴滴订单问题回答错误记录表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusDidiOrderAnswerWrongRecordRepoImpl extends ServiceImpl<BusDidiOrderAnswerWrongRecordMapper, BusDidiOrderAnswerWrongRecord> implements BusDidiOrderAnswerWrongRecordRepo {

}
