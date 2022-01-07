package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.LiveWorker;
import com.xeg.servers.order.domain.mapper.LiveWorkerMapper;
import com.xeg.servers.order.domain.repository.LiveWorkerRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工人直播间排队信息 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class LiveWorkerRepoImpl extends ServiceImpl<LiveWorkerMapper, LiveWorker> implements LiveWorkerRepo {

}
