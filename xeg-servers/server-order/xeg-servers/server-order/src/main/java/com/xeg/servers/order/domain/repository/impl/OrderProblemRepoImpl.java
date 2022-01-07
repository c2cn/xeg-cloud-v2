package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderProblem;
import com.xeg.servers.order.domain.mapper.OrderProblemMapper;
import com.xeg.servers.order.domain.repository.OrderProblemRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 雇主下单时技能要求 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderProblemRepoImpl extends ServiceImpl<OrderProblemMapper, OrderProblem> implements OrderProblemRepo {

}
