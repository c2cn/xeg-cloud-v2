package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderStatistics;
import com.xeg.servers.order.domain.mapper.OrderStatisticsMapper;
import com.xeg.servers.order.domain.repository.OrderStatisticsRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单信息统计 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderStatisticsRepoImpl extends ServiceImpl<OrderStatisticsMapper, OrderStatistics> implements OrderStatisticsRepo {

}
