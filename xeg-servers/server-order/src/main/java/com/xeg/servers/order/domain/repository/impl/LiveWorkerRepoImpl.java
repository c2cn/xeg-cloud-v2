package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.LiveWorker;
import com.xeg.servers.order.domain.mapper.LiveWorkerMapper;
import com.xeg.servers.order.domain.repository.LiveWorkerRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:39
	* @version v1.0.0
	* @Description	工人直播间排队信息 服务实现类
	* LiveWorkerRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:39       xian            v1.0.0           Created
 */
@Service
public class LiveWorkerRepoImpl extends ServiceImpl<LiveWorkerMapper, LiveWorker> implements LiveWorkerRepo {

}
