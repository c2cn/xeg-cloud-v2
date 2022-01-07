package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderOffer;
import com.xeg.servers.order.domain.mapper.OrderOfferMapper;
import com.xeg.servers.order.domain.repository.OrderOfferRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工人议价信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderOfferRepoImpl extends ServiceImpl<OrderOfferMapper, OrderOffer> implements OrderOfferRepo {

}
