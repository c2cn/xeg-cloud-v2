package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusNoticeOrderTime;
import com.xeg.servers.order.domain.mapper.BusNoticeOrderTimeMapper;
import com.xeg.servers.order.domain.repository.BusNoticeOrderTimeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短工大厅雇主订单每天工作时间 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusNoticeOrderTimeRepoImpl extends ServiceImpl<BusNoticeOrderTimeMapper, BusNoticeOrderTime> implements BusNoticeOrderTimeRepo {

}
