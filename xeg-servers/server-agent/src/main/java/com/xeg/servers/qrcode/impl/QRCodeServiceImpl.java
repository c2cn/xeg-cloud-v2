package com.xeg.servers.qrcode.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.zxing.qrcode.encoder.QRCode;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.servers.base.bean.enums.IsDelEnum;
import com.xeg.servers.qrcode.api.QRCodeService;
import com.xeg.servers.qrcode.bean.vo.QRCodeVO;
import com.xeg.servers.qrcode.domain.entity.QrCode;
import com.xeg.servers.qrcode.domain.repository.QrCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:47
 * @Description ---
 * QRCodeServiceImpl
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:47 xulp v1.0.0 Created
 */
@RestController
@RequestMapping("/feign/QRCode")
public class QRCodeServiceImpl implements QRCodeService {
    @Autowired
    private QrCodeRepo qrCodeRepo;

    @Override
    public JsonResult<QRCodeVO> getQRCodeByAgentIdentityId(Long agentIdentityId) {
        LambdaQueryWrapper<QrCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(QrCode::getAgentIdentityId, agentIdentityId)
                .eq(QrCode::getDel, IsDelEnum.NO.getValue());
        return JsonResultUtils.success(BeanUtils.copyObject(qrCodeRepo.getOne(wrapper), new QRCodeVO()));
    }
}
