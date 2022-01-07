package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderShareRecord;
import com.xeg.servers.order.domain.mapper.NoticeOrderShareRecordMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderShareRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:47:03
	* @version v1.0.0
	* @Description	订单分享记录表 服务实现类
	* NoticeOrderShareRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:47:03       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderShareRecordRepoImpl extends ServiceImpl<NoticeOrderShareRecordMapper, NoticeOrderShareRecord> implements NoticeOrderShareRecordRepo {

}
