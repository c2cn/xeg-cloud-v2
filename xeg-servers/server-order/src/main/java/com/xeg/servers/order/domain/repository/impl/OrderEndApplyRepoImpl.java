package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEndApply;
import com.xeg.servers.order.domain.mapper.OrderEndApplyMapper;
import com.xeg.servers.order.domain.repository.OrderEndApplyRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:14
	* @version v1.0.0
	* @Description	订单结束申请 服务实现类
	* OrderEndApplyRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:14       xian            v1.0.0           Created
 */
@Service
public class OrderEndApplyRepoImpl extends ServiceImpl<OrderEndApplyMapper, OrderEndApply> implements OrderEndApplyRepo {

}
