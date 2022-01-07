package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderEndRejectRecord;
import com.xeg.servers.order.domain.mapper.OrderEndRejectRecordMapper;
import com.xeg.servers.order.domain.repository.OrderEndRejectRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:48:22
	* @version v1.0.0
	* @Description	申请完成订单拒绝记录 服务实现类
	* OrderEndRejectRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:48:22       xian            v1.0.0           Created
 */
@Service
public class OrderEndRejectRecordRepoImpl extends ServiceImpl<OrderEndRejectRecordMapper, OrderEndRejectRecord> implements OrderEndRejectRecordRepo {

}
