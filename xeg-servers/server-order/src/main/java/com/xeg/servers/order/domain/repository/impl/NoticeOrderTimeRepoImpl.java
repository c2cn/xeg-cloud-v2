package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderTime;
import com.xeg.servers.order.domain.mapper.NoticeOrderTimeMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderTimeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:47:13
	* @version v1.0.0
	* @Description	短工大厅雇主订单每天工作时间 服务实现类
	* NoticeOrderTimeRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:47:13       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderTimeRepoImpl extends ServiceImpl<NoticeOrderTimeMapper, NoticeOrderTime> implements NoticeOrderTimeRepo {

}
