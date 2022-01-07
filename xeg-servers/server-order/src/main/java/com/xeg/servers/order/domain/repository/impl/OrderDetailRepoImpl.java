package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderDetail;
import com.xeg.servers.order.domain.mapper.OrderDetailMapper;
import com.xeg.servers.order.domain.repository.OrderDetailRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:05
	* @version v1.0.0
	* @Description	订单详细信息表 服务实现类
	* OrderDetailRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:05       xian            v1.0.0           Created
 */
@Service
public class OrderDetailRepoImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailRepo {

}
