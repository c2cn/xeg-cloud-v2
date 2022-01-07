package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusOrderMaliciousType;
import com.xeg.servers.order.domain.mapper.BusOrderMaliciousTypeMapper;
import com.xeg.servers.order.domain.repository.BusOrderMaliciousTypeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 举报类型表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusOrderMaliciousTypeRepoImpl extends ServiceImpl<BusOrderMaliciousTypeMapper, BusOrderMaliciousType> implements BusOrderMaliciousTypeRepo {

}
