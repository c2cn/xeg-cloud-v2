package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEndRejectRecord;
import com.xeg.servers.order.domain.mapper.OrderEndRejectRecordMapper;
import com.xeg.servers.order.domain.repository.OrderEndRejectRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 申请完成订单拒绝记录 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderEndRejectRecordRepoImpl extends ServiceImpl<OrderEndRejectRecordMapper, OrderEndRejectRecord> implements OrderEndRejectRecordRepo {

}
