package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderRepair;
import com.xeg.servers.order.domain.mapper.OrderRepairMapper;
import com.xeg.servers.order.domain.repository.OrderRepairRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:19
	* @version v1.0.0
	* @Description	订单补救措施表 服务实现类
	* OrderRepairRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:19       xian            v1.0.0           Created
 */
@Service
public class OrderRepairRepoImpl extends ServiceImpl<OrderRepairMapper, OrderRepair> implements OrderRepairRepo {

}
