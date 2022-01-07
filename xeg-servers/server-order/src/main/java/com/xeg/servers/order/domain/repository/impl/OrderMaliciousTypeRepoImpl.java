package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderMaliciousType;
import com.xeg.servers.order.domain.mapper.OrderMaliciousTypeMapper;
import com.xeg.servers.order.domain.repository.OrderMaliciousTypeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:51
	* @version v1.0.0
	* @Description	举报类型表 服务实现类
	* OrderMaliciousTypeRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:51       xian            v1.0.0           Created
 */
@Service
public class OrderMaliciousTypeRepoImpl extends ServiceImpl<OrderMaliciousTypeMapper, OrderMaliciousType> implements OrderMaliciousTypeRepo {

}
