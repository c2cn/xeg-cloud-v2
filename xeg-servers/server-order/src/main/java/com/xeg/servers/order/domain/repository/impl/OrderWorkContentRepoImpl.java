package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderWorkContent;
import com.xeg.servers.order.domain.mapper.OrderWorkContentMapper;
import com.xeg.servers.order.domain.repository.OrderWorkContentRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:56
	* @version v1.0.0
	* @Description	订单工作内容模板 服务实现类
	* OrderWorkContentRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:56       xian            v1.0.0           Created
 */
@Service
public class OrderWorkContentRepoImpl extends ServiceImpl<OrderWorkContentMapper, OrderWorkContent> implements OrderWorkContentRepo {

}
