package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.ChatRoom;
import com.xeg.servers.order.domain.mapper.ChatRoomMapper;
import com.xeg.servers.order.domain.repository.ChatRoomRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:44:51
	* @version v1.0.0
	* @Description	聊天室 服务实现类
	* ChatRoomRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:44:51       xian            v1.0.0           Created
 */
@Service
public class ChatRoomRepoImpl extends ServiceImpl<ChatRoomMapper, ChatRoom> implements ChatRoomRepo {

}
