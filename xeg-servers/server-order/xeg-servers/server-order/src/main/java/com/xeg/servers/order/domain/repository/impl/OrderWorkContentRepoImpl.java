package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderWorkContent;
import com.xeg.servers.order.domain.mapper.OrderWorkContentMapper;
import com.xeg.servers.order.domain.repository.OrderWorkContentRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单工作内容模板 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class OrderWorkContentRepoImpl extends ServiceImpl<OrderWorkContentMapper, OrderWorkContent> implements OrderWorkContentRepo {

}
