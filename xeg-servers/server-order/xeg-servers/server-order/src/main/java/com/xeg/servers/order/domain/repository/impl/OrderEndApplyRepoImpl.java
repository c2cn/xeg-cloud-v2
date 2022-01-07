package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEndApply;
import com.xeg.servers.order.domain.mapper.OrderEndApplyMapper;
import com.xeg.servers.order.domain.repository.OrderEndApplyRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单结束申请 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderEndApplyRepoImpl extends ServiceImpl<OrderEndApplyMapper, OrderEndApply> implements OrderEndApplyRepo {

}
