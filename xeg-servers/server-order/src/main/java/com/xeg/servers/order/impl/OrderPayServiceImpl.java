package com.xeg.servers.order.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xeg.servers.order.api.OrderPayService;
import com.xeg.servers.order.bean.vo.OrderQueryInfoVO;
import com.xeg.servers.order.domain.entity.OrderQueryInfo;
import com.xeg.servers.order.domain.mapper.OrderQueryMapper;
import com.xeg.servers.order.domain.repository.OrderRepo;

import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年11月4日 下午6:25:31
	* @version v1.0.0
	* @Description	订单支付相关业务实现
	* OrderPayServiceImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午6:25:31       xian            v1.0.0           Created
 */
@Slf4j
@RestController
@RequestMapping("/feign/orderPay")
public class OrderPayServiceImpl implements OrderPayService {
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderQueryMapper orderQueryMapper;
	
	@Override
	public OrderQueryInfoVO getOrderBasicInfoByOrderNo(String orderNo) {
		log.info("getOrderBasicInfoByOrderNo...");
		
		OrderQueryInfo qrderQueryInfo = orderQueryMapper.getOrderBasicInfoByOrderNo(orderNo);
		log.info("qrderQueryInfo = " + JSON.toJSONString(qrderQueryInfo));
		
		// 返回对象拷贝
		OrderQueryInfoVO orderQueryInfoVO = new OrderQueryInfoVO();
		BeanUtils.copyProperties(qrderQueryInfo, orderQueryInfoVO);
		log.info("orderQueryInfoVO = " + JSON.toJSONString(orderQueryInfoVO));
		
		return orderQueryInfoVO;
	}
	
	
	
}
