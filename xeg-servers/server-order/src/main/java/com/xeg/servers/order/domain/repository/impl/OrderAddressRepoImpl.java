package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderAddress;
import com.xeg.servers.order.domain.mapper.OrderAddressMapper;
import com.xeg.servers.order.domain.repository.OrderAddressRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:47:42
	* @version v1.0.0
	* @Description	订单地点信息表 服务实现类
	* OrderAddressRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:47:42       xian            v1.0.0           Created
 */
@Service
public class OrderAddressRepoImpl extends ServiceImpl<OrderAddressMapper, OrderAddress> implements OrderAddressRepo {

}
