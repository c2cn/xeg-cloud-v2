package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.ChatUser;
import com.xeg.servers.order.domain.mapper.ChatUserMapper;
import com.xeg.servers.order.domain.repository.ChatUserRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:01
	* @version v1.0.0
	* @Description	聊天用户 服务实现类
	* ChatUserRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:01       xian            v1.0.0           Created
 */
@Service
public class ChatUserRepoImpl extends ServiceImpl<ChatUserMapper, ChatUser> implements ChatUserRepo {

}
