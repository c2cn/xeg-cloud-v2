package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.Settlement;
import com.xeg.servers.order.domain.mapper.SettlementMapper;
import com.xeg.servers.order.domain.repository.SettlementRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:50:05
	* @version v1.0.0
	* @Description	分成快照表 服务实现类
	* SettlementRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:50:05       xian            v1.0.0           Created
 */
@Service
public class SettlementRepoImpl extends ServiceImpl<SettlementMapper, Settlement> implements SettlementRepo {

}
