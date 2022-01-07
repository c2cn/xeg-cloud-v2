package com.xeg.servers.pay.domain.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xeg.servers.pay.domain.entity.PaycallbackFailRecord;

/**
	* @author xian
	* @date   2021年11月4日 下午2:09:07
	* @version v1.0.0
	* @Description	支付回调失败记录表 服务类
	* PaycallbackFailRecordRepo.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午2:09:07       xian            v1.0.0           Created
 */
public interface PaycallbackFailRecordRepo extends IService<PaycallbackFailRecord> {
	
	/**
	* @Title: getPayCallBackResult  
	* @Description: 2021年11月4日 下午2:07:18 查询失败记录
	* @param @param orderNo
	* @param @param uid
	* @param @param sceneType
	* @param @return    参数  
	* @return PaycallbackFailRecord    返回类型  
	* @throws
	 */
	PaycallbackFailRecord getPayCallBackResult(String orderNo, int uid, int sceneType);

}
