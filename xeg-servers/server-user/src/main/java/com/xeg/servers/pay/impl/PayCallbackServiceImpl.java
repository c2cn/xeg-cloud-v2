package com.xeg.servers.pay.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.cores.server.FeignReference;
import com.xeg.servers.order.api.OrderPayService;
import com.xeg.servers.order.bean.enums.OrderSourceEnum;
import com.xeg.servers.order.bean.vo.OrderQueryInfoVO;
import com.xeg.servers.pay.api.PayCallbackService;
import com.xeg.servers.pay.bean.dto.EmployerPayCallbackDTO;
import com.xeg.servers.pay.bean.enums.CallbackSceneTypeEnum;
import com.xeg.servers.pay.bean.vo.PayCallBackResultVO;
import com.xeg.servers.pay.domain.entity.PaycallbackFailRecord;
import com.xeg.servers.pay.domain.repository.PaycallbackFailRecordRepo;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年11月4日 上午11:39:40
	* @version v1.0.0
	* @Description	支付回调业务实现
	* PayCallbackServiceImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 上午11:39:40       xian            v1.0.0           Created
 */
@Slf4j
@RestController
@RequestMapping("/feign/payCallback")
public class PayCallbackServiceImpl implements PayCallbackService {
	
	@Autowired
	private PaycallbackFailRecordRepo paycallbackFailRecordRepo;
	
	@FeignReference
	private OrderPayService orderPayService;
	
	@Override
	public JsonResult<PayCallBackResultVO> getPayCallBackResult(EmployerPayCallbackDTO dto) {
		log.info("getPayCallBackResult...dto = " + JSON.toJSONString(dto));
		String orderNo = dto.getOrderNo(); // 订单编号
		int uid = 1;
		int orderSource = dto.getOrderSource(); // 订单来源
		int sceneType = dto.getSceneType(); // 支付业务类型
		// 返回对象
		PayCallBackResultVO payCallBackResultVO = new PayCallBackResultVO();
		
		// 查询失败记录
		PaycallbackFailRecord paycallbackFailRecord = paycallbackFailRecordRepo.getPayCallBackResult(orderNo, uid, sceneType);
		if (ObjectUtil.isNotNull(paycallbackFailRecord)) {
			log.info("isNotNull...");
            // 不为空视为失败,返回失败记录
            BeanUtils.copyProperties(payCallBackResultVO, paycallbackFailRecord);
            // 赋值BID
            payCallBackResultVO.setBid(paycallbackFailRecord.getId());
            payCallBackResultVO.setFailStatus(1);
            return JsonResultUtils.success(payCallBackResultVO);
        }
		log.info("paycallbackFailRecord is null...");
		
		/** 发单场景 */
        if (CallbackSceneTypeEnum.ST20.value == sceneType) {
        	// 公告单
            if (orderSource == OrderSourceEnum.NOTICE.value) {
//                NoticeOrderInfo noticeOrderInfo = empNoticeOrderMapper.getNoticeBasicOrderByOrderNo(orderNo);
//                String orderBatch = noticeOrderInfo.getOrderBatch();
//                payCallBackResultVO.setOrderNo(orderNo);
//                payCallBackResultVO.setOrderBatch(orderBatch);
//                //
//                payCallBackResultVO.setIsDispatch(1);
//                payCallBackResultVO.setNoticeDuration(noticeOrderInfo.getNoticeDuration());
            } else {
                // 订单基础信息发单返回orderNo和orderBatch
            	OrderQueryInfoVO orderQueryInfoVO = orderPayService.getOrderBasicInfoByOrderNo(orderNo);
                String orderBatch = orderQueryInfoVO.getOrderBatch();
                payCallBackResultVO.setOrderNo(orderNo);
                payCallBackResultVO.setOrderBatch(orderBatch);
                // 是否派单 TODO
//                if (orderCacheOperation.readOrderDispatchEndStatus(orderNo) == null) {
//                    payCallBackResultVO.setIsDispatch(1);
//                }
            }
        }
		
		
		return JsonResultUtils.success(payCallBackResultVO);
	}

}
