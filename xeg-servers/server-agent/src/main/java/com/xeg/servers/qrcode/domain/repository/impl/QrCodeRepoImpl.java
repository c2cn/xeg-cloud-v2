package com.xeg.servers.qrcode.domain.repository.impl;

import com.xeg.servers.qrcode.domain.entity.QrCode;
import com.xeg.servers.qrcode.domain.mapper.QrCodeMapper;
import com.xeg.servers.qrcode.domain.repository.QrCodeRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 二维码 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-09
 */
@Service
public class QrCodeRepoImpl extends ServiceImpl<QrCodeMapper, QrCode> implements QrCodeRepo {

}
