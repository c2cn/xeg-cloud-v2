package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderDetail;
import com.xeg.servers.order.domain.mapper.NoticeOrderDetailMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderDetailRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:16
	* @version v1.0.0
	* @Description	短工大厅订单详情表 服务实现类
	* NoticeOrderDetailRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:16       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderDetailRepoImpl extends ServiceImpl<NoticeOrderDetailMapper, NoticeOrderDetail> implements NoticeOrderDetailRepo {

}
