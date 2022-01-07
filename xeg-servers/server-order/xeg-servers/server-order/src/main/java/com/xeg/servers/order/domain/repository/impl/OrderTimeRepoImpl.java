package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderTime;
import com.xeg.servers.order.domain.mapper.OrderTimeMapper;
import com.xeg.servers.order.domain.repository.OrderTimeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 雇主订单每天工作时间 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderTimeRepoImpl extends ServiceImpl<OrderTimeMapper, OrderTime> implements OrderTimeRepo {

}
