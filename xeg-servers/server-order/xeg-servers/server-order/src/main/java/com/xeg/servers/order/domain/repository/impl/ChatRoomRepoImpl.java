package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.ChatRoom;
import com.xeg.servers.order.domain.mapper.ChatRoomMapper;
import com.xeg.servers.order.domain.repository.ChatRoomRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 聊天室 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class ChatRoomRepoImpl extends ServiceImpl<ChatRoomMapper, ChatRoom> implements ChatRoomRepo {

}
