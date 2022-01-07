package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.Settlement;
import com.xeg.servers.order.domain.mapper.SettlementMapper;
import com.xeg.servers.order.domain.repository.SettlementRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分成快照表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class SettlementRepoImpl extends ServiceImpl<SettlementMapper, Settlement> implements SettlementRepo {

}
