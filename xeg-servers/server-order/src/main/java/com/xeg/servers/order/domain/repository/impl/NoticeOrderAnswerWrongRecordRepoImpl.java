package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderAnswerWrongRecord;
import com.xeg.servers.order.domain.mapper.NoticeOrderAnswerWrongRecordMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderAnswerWrongRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:06
	* @version v1.0.0
	* @Description	短工大厅订单问题回答错误记录表 服务实现类
	* NoticeOrderAnswerWrongRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:06       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderAnswerWrongRecordRepoImpl extends ServiceImpl<NoticeOrderAnswerWrongRecordMapper, NoticeOrderAnswerWrongRecord> implements NoticeOrderAnswerWrongRecordRepo {

}
