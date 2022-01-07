package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrder;
import com.xeg.servers.order.domain.mapper.NoticeOrderMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:54
	* @version v1.0.0
	* @Description	短工大厅订单基本信息表 服务实现类
	* NoticeOrderRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:54       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderRepoImpl extends ServiceImpl<NoticeOrderMapper, NoticeOrder> implements NoticeOrderRepo {

}
