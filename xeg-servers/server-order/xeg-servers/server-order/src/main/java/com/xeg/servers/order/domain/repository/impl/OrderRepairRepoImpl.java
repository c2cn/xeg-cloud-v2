package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderRepair;
import com.xeg.servers.order.domain.mapper.OrderRepairMapper;
import com.xeg.servers.order.domain.repository.OrderRepairRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单补救措施表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderRepairRepoImpl extends ServiceImpl<OrderRepairMapper, OrderRepair> implements OrderRepairRepo {

}
