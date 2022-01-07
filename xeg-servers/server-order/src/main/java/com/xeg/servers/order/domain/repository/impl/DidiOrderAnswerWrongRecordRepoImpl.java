package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.DidiOrderAnswerWrongRecord;
import com.xeg.servers.order.domain.mapper.DidiOrderAnswerWrongRecordMapper;
import com.xeg.servers.order.domain.repository.DidiOrderAnswerWrongRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:20
	* @version v1.0.0
	* @Description	滴滴订单问题回答错误记录表 服务实现类
	* DidiOrderAnswerWrongRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:20       xian            v1.0.0           Created
 */
@Service
public class DidiOrderAnswerWrongRecordRepoImpl extends ServiceImpl<DidiOrderAnswerWrongRecordMapper, DidiOrderAnswerWrongRecord> implements DidiOrderAnswerWrongRecordRepo {

}
