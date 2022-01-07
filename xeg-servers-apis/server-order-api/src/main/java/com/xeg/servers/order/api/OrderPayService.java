package com.xeg.servers.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xeg.servers.order.bean.vo.OrderQueryInfoVO;

/**
	* @author xian
	* @date   2021年11月4日 下午6:22:54
	* @version v1.0.0
	* @Description	订单支付相关服务接口
	* OrderPayService.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午6:22:54       xian            v1.0.0           Created
 */
@FeignClient(name = "server-order", path = "/feign/orderPay", contextId = "orderPay")
public interface OrderPayService {
	@PostMapping("/getOrderBasicInfoByOrderNo")
	OrderQueryInfoVO getOrderBasicInfoByOrderNo(@RequestBody String orderNo);
}
