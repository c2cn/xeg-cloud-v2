package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderDetail;
import com.xeg.servers.order.domain.mapper.OrderDetailMapper;
import com.xeg.servers.order.domain.repository.OrderDetailRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详细信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderDetailRepoImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailRepo {

}
