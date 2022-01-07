package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusOrderMalicious;
import com.xeg.servers.order.domain.mapper.BusOrderMaliciousMapper;
import com.xeg.servers.order.domain.repository.BusOrderMaliciousRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 恶意订单表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusOrderMaliciousRepoImpl extends ServiceImpl<BusOrderMaliciousMapper, BusOrderMalicious> implements BusOrderMaliciousRepo {

}
