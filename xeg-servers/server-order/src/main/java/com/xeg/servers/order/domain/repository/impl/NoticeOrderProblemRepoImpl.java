package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderProblem;
import com.xeg.servers.order.domain.mapper.NoticeOrderProblemMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderProblemRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:45
	* @version v1.0.0
	* @Description	短工大厅雇主下单时技能要求 服务实现类
	* NoticeOrderProblemRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:45       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderProblemRepoImpl extends ServiceImpl<NoticeOrderProblemMapper, NoticeOrderProblem> implements NoticeOrderProblemRepo {

}
