package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusOrderComplaint;
import com.xeg.servers.order.domain.mapper.BusOrderComplaintMapper;
import com.xeg.servers.order.domain.repository.BusOrderComplaintRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单举报表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusOrderComplaintRepoImpl extends ServiceImpl<BusOrderComplaintMapper, BusOrderComplaint> implements BusOrderComplaintRepo {

}
