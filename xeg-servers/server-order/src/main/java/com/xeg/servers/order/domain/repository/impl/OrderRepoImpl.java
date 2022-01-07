package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderInfo;
import com.xeg.servers.order.domain.mapper.OrderMapper;
import com.xeg.servers.order.domain.repository.OrderRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:29
	* @version v1.0.0
	* @Description	订单基本信息表 服务实现类
	* OrderRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:29       xian            v1.0.0           Created
 */
@Service
public class OrderRepoImpl extends ServiceImpl<OrderMapper, OrderInfo> implements OrderRepo {

}
