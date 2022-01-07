package com.xeg.servers.user.domain.repository.impl;

import com.xeg.servers.user.domain.entity.PaycallbackFailRecord;
import com.xeg.servers.user.domain.mapper.PaycallbackFailRecordMapper;
import com.xeg.servers.user.domain.repository.PaycallbackFailRecordRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付回调失败记录表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Service
public class PaycallbackFailRecordRepoImpl extends ServiceImpl<PaycallbackFailRecordMapper, PaycallbackFailRecord> implements PaycallbackFailRecordRepo {

}
