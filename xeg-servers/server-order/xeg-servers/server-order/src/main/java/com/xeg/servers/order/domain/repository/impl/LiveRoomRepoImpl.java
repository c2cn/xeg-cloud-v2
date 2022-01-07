package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.LiveRoom;
import com.xeg.servers.order.domain.mapper.LiveRoomMapper;
import com.xeg.servers.order.domain.repository.LiveRoomRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播间 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class LiveRoomRepoImpl extends ServiceImpl<LiveRoomMapper, LiveRoom> implements LiveRoomRepo {

}
