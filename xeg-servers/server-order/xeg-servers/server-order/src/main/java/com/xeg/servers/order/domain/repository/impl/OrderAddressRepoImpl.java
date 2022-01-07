package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderAddress;
import com.xeg.servers.order.domain.mapper.OrderAddressMapper;
import com.xeg.servers.order.domain.repository.OrderAddressRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单地点信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderAddressRepoImpl extends ServiceImpl<OrderAddressMapper, OrderAddress> implements OrderAddressRepo {

}
