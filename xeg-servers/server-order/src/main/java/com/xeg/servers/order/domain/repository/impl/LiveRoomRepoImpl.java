package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.LiveRoom;
import com.xeg.servers.order.domain.mapper.LiveRoomMapper;
import com.xeg.servers.order.domain.repository.LiveRoomRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:29
	* @version v1.0.0
	* @Description	直播间 服务实现类
	* LiveRoomRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:29       xian            v1.0.0           Created
 */
@Service
public class LiveRoomRepoImpl extends ServiceImpl<LiveRoomMapper, LiveRoom> implements LiveRoomRepo {

}
