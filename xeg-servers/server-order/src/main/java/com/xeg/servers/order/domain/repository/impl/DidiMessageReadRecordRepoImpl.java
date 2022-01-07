package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.DidiMessageReadRecord;
import com.xeg.servers.order.domain.mapper.DidiMessageReadRecordMapper;
import com.xeg.servers.order.domain.repository.DidiMessageReadRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:10
	* @version v1.0.0
	* @Description	滴滴单消息阅读记录表 服务实现类
	* DidiMessageReadRecordRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:10       xian            v1.0.0           Created
 */
@Service
public class DidiMessageReadRecordRepoImpl extends ServiceImpl<DidiMessageReadRecordMapper, DidiMessageReadRecord> implements DidiMessageReadRecordRepo {

}
