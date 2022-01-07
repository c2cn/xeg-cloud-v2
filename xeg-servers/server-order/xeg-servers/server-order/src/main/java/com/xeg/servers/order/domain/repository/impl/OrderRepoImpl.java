package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.Order;
import com.xeg.servers.order.domain.mapper.OrderMapper;
import com.xeg.servers.order.domain.repository.OrderRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单基本信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderRepoImpl extends ServiceImpl<OrderMapper, Order> implements OrderRepo {

}
