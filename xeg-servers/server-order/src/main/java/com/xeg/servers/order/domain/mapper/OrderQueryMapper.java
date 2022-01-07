package com.xeg.servers.order.domain.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeg.servers.order.domain.entity.OrderInfo;
import com.xeg.servers.order.domain.entity.OrderQueryInfo;

/**
	* @author xian
	* @date   2021年11月4日 下午6:05:05
	* @version v1.0.0
	* @Description	订单基本信息表 Mapper 查询接口
	* OrderMapper.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午6:05:05       xian            v1.0.0           Created
 */
public interface OrderQueryMapper extends BaseMapper<OrderInfo> {
	
	@Select("select t1.order_no, t1.employer_id, t1.live_id, t1.order_source, t1.order_type, t1.order_batch, "
			+ "t1.`number`, t1.hourly_wage, t1.per_money, t1.total_money, t1.money_mode, t1.`position`, "
			+ "t1.`content`, t1.bond_money, t1.status, t1.confirm_status, t1.error_status, t1.evaluate_status, "
			+ "t1.chat_status, t1.repair_mark, t1.edit_mark, t1.standard_mark, t1.create_time, t1.pay_time, "
			+ "t1.dispatch_end_time, t1.end_time, t1.is_admin_end, t2.work_division_code, t2.work_area, "
			+ "t2.work_lat, t2.work_lng, t2.release_division_code, t2.release_area, t2.release_lat, t2.release_lng, "
			+ "t2.pickup_division_code, t2.pickup_area, t2.pickup_lat, t2.pickup_lng, t3.edit_num, t3.didi_num, "
			+ "t3.offer_num, t3.entrust_num, t3.use_status, t1.order_form_type "
			+ "from xeg_order t1 left join xeg_order_address t2 on t1.order_no = t2.order_no "
			+ "left join xeg_order_repair t3 on t1.order_batch = t3.order_batch "
			+ "where t1.order_no = '${orderNo}' and t1.is_del = 0 ")
	OrderQueryInfo getOrderBasicInfoByOrderNo(@Param("orderNo") String orderNo);
	
	
//	// 查询失败记录
//		@Select("select * from bus_paycallback_fail_record "
//				+ "where uid = ${uid} and order_no = '${orderNo}' and scene_type = ${sceneType} and is_del = 0 ")
//		PaycallbackFailRecord getPayCallBackResult(@Param("orderNo") String orderNo, @Param("uid") int uid, 
//				@Param("sceneType") int sceneType);
}
