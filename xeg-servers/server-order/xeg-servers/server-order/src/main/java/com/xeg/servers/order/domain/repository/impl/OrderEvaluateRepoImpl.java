package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEvaluate;
import com.xeg.servers.order.domain.mapper.OrderEvaluateMapper;
import com.xeg.servers.order.domain.repository.OrderEvaluateRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单评价表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderEvaluateRepoImpl extends ServiceImpl<OrderEvaluateMapper, OrderEvaluate> implements OrderEvaluateRepo {

}
