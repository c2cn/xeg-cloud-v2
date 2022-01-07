package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderTime;
import com.xeg.servers.order.domain.mapper.OrderTimeMapper;
import com.xeg.servers.order.domain.repository.OrderTimeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:47
	* @version v1.0.0
	* @Description	雇主订单每天工作时间 服务实现类
	* OrderTimeRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:47       xian            v1.0.0           Created
 */
@Service
public class OrderTimeRepoImpl extends ServiceImpl<OrderTimeMapper, OrderTime> implements OrderTimeRepo {

}
