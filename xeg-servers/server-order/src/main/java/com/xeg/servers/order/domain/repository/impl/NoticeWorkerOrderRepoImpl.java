package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeWorkerOrder;
import com.xeg.servers.order.domain.mapper.NoticeWorkerOrderMapper;
import com.xeg.servers.order.domain.repository.NoticeWorkerOrderRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:47:32
	* @version v1.0.0
	* @Description	短工大厅工人订单表 服务实现类
	* NoticeWorkerOrderRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:47:32       xian            v1.0.0           Created
 */
@Service
public class NoticeWorkerOrderRepoImpl extends ServiceImpl<NoticeWorkerOrderMapper, NoticeWorkerOrder> implements NoticeWorkerOrderRepo {

}
