package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderProblem;
import com.xeg.servers.order.domain.mapper.OrderProblemMapper;
import com.xeg.servers.order.domain.repository.OrderProblemRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:10
	* @version v1.0.0
	* @Description	雇主下单时技能要求 服务实现类
	* OrderProblemRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:10       xian            v1.0.0           Created
 */
@Service
public class OrderProblemRepoImpl extends ServiceImpl<OrderProblemMapper, OrderProblem> implements OrderProblemRepo {

}
