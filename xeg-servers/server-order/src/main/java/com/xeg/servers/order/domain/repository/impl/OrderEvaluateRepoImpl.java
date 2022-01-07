package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEvaluate;
import com.xeg.servers.order.domain.mapper.OrderEvaluateMapper;
import com.xeg.servers.order.domain.repository.OrderEvaluateRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:31
	* @version v1.0.0
	* @Description	订单评价表 服务实现类
	* OrderEvaluateRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:31       xian            v1.0.0           Created
 */
@Service
public class OrderEvaluateRepoImpl extends ServiceImpl<OrderEvaluateMapper, OrderEvaluate> implements OrderEvaluateRepo {

}
