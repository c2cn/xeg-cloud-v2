package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.BusDidiMessageReadRecord;
import com.xeg.servers.order.domain.mapper.BusDidiMessageReadRecordMapper;
import com.xeg.servers.order.domain.repository.BusDidiMessageReadRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 滴滴单消息阅读记录表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class BusDidiMessageReadRecordRepoImpl extends ServiceImpl<BusDidiMessageReadRecordMapper, BusDidiMessageReadRecord> implements BusDidiMessageReadRecordRepo {

}
