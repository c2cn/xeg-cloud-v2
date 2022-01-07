package com.xeg.apps.common.app.pay.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.server.FeignReference;
import com.xeg.servers.pay.api.PayCallbackService;
import com.xeg.servers.pay.bean.dto.EmployerPayCallbackDTO;
import com.xeg.servers.pay.bean.enums.CallbackSceneTypeEnum;
import com.xeg.servers.pay.bean.vo.PayCallBackResultVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年11月4日 上午10:54:48
	* @version v1.0.0
	* @Description	订单支付相关
	* EmployerPayCallBackController.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 上午10:54:48       xian            v1.0.0           Created
 */
@Slf4j
@RestController
@RequestMapping("/employer/order")
@Api(tags = "7010雇主支付回调相关")
public class EmployerPayCallbackController {
	@FeignReference
	private PayCallbackService payCallbackService;

    @ApiOperation(value = "70101查询雇主发单的支付保证金回调结果")
    @PostMapping(value = "/paycallback/publish/get")
    public JsonResult<PayCallBackResultVO> payCallback(@Valid EmployerPayCallbackDTO dto) {
    	log.info("payCallback...dto = " + JSON.toJSONString(dto));
        
    	// 查询保证金支付回调
    	dto.setSceneType(CallbackSceneTypeEnum.ST20.value);
        JsonResult<PayCallBackResultVO> jsonResult = payCallbackService.getPayCallBackResult(dto);
        log.info("jsonResult = " + JSON.toJSONString(jsonResult));
        
        return jsonResult;
    }
	
}
