package com.xeg.servers.pay.domain.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeg.servers.pay.domain.entity.PaycallbackFailRecord;

/**
	* @author xian
	* @date   2021年11月4日 下午2:01:54
	* @version v1.0.0
	* @Description	支付回调失败记录表 Mapper 接口
	* PaycallbackFailRecordMapper.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午2:01:54       xian            v1.0.0           Created
 */
public interface PaycallbackFailRecordMapper extends BaseMapper<PaycallbackFailRecord> {
	
	// 查询失败记录
	@Select("select * from bus_paycallback_fail_record "
			+ "where uid = ${uid} and order_no = '${orderNo}' and scene_type = ${sceneType} and is_del = 0 ")
	PaycallbackFailRecord getPayCallBackResult(@Param("orderNo") String orderNo, @Param("uid") int uid, 
			@Param("sceneType") int sceneType);
	
}
