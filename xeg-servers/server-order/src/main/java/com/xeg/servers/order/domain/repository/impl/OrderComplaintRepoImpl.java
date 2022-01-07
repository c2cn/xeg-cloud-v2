package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderComplaint;
import com.xeg.servers.order.domain.mapper.OrderComplaintMapper;
import com.xeg.servers.order.domain.repository.OrderComplaintRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:47:55
	* @version v1.0.0
	* @Description	订单举报表 服务实现类
	* OrderComplaintRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:47:55       xian            v1.0.0           Created
 */
@Service
public class OrderComplaintRepoImpl extends ServiceImpl<OrderComplaintMapper, OrderComplaint> implements OrderComplaintRepo {

}
