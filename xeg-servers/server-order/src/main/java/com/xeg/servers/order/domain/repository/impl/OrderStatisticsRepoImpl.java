package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.OrderStatistics;
import com.xeg.servers.order.domain.mapper.OrderStatisticsMapper;
import com.xeg.servers.order.domain.repository.OrderStatisticsRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:49:38
	* @version v1.0.0
	* @Description	订单信息统计 服务实现类
	* OrderStatisticsRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:49:38       xian            v1.0.0           Created
 */
@Service
public class OrderStatisticsRepoImpl extends ServiceImpl<OrderStatisticsMapper, OrderStatistics> implements OrderStatisticsRepo {

}
