package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderMalicious;
import com.xeg.servers.order.domain.mapper.OrderMaliciousMapper;
import com.xeg.servers.order.domain.repository.OrderMaliciousRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:40
	* @version v1.0.0
	* @Description	恶意订单表 服务实现类
	* OrderMaliciousRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:40       xian            v1.0.0           Created
 */
@Service
public class OrderMaliciousRepoImpl extends ServiceImpl<OrderMaliciousMapper, OrderMalicious> implements OrderMaliciousRepo {

}
