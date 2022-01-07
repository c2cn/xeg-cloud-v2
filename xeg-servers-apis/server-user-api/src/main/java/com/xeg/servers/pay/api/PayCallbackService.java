package com.xeg.servers.pay.api;

import com.xeg.servers.pay.bean.dto.EmployerPayCallbackDTO;
import com.xeg.servers.pay.bean.vo.PayCallBackResultVO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xeg.cores.base.http.JsonResult;

/**
	* @author xian
	* @date   2021年11月4日 上午11:40:03
	* @version v1.0.0
	* @Description 支付回调接口
	* PayCallbackService.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 上午11:40:03       xian            v1.0.0           Created
 */
@FeignClient(name = "server-user", path = "/feign/payCallback", contextId = "payCallback")
public interface PayCallbackService {
	
	/**
	* @Title: getPayCallBackResult  
	* @Description: 2021年11月4日 下午1:37:32 查询保证金支付回调
	* @param @param orderNo
	* @param @param employerId
	* @param @param orderSource
	* @param @param sceneType
	* @param @return    参数  
	* @return JsonResult<PayCallBackResultVO>    返回类型  
	* @throws
	 */
	@PostMapping("/getPayCallBackResult")
	JsonResult<PayCallBackResultVO> getPayCallBackResult(@RequestBody EmployerPayCallbackDTO dto);
}
