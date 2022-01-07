package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.ChatUser;
import com.xeg.servers.order.domain.mapper.ChatUserMapper;
import com.xeg.servers.order.domain.repository.ChatUserRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * IM  聊天用户 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class ChatUserRepoImpl extends ServiceImpl<ChatUserMapper, ChatUser> implements ChatUserRepo {

}
