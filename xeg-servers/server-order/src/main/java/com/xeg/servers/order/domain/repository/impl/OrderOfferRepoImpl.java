package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderOffer;
import com.xeg.servers.order.domain.mapper.OrderOfferMapper;
import com.xeg.servers.order.domain.repository.OrderOfferRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:00
	* @version v1.0.0
	* @Description	工人议价信息表 服务实现类
	* OrderOfferRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:00       xian            v1.0.0           Created
 */
@Service
public class OrderOfferRepoImpl extends ServiceImpl<OrderOfferMapper, OrderOffer> implements OrderOfferRepo {

}
