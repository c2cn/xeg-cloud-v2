package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusNoticeOrder;
import com.xeg.servers.order.domain.mapper.BusNoticeOrderMapper;
import com.xeg.servers.order.domain.repository.BusNoticeOrderRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短工大厅订单基本信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusNoticeOrderRepoImpl extends ServiceImpl<BusNoticeOrderMapper, BusNoticeOrder> implements BusNoticeOrderRepo {

}
