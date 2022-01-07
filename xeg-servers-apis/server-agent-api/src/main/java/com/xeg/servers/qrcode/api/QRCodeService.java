package com.xeg.servers.qrcode.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.qrcode.bean.vo.QRCodeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:49
 * @Description 二维码服务
 * QRCodeService
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:49 xulp v1.0.0 Created
 */
@FeignClient(name = "server-agent", path = "/feign/QRCode", contextId = "QRCode")
public interface QRCodeService {


    /**
     * @param agentIdentityId 代理的身份标识 参数
     * @return {@link JsonResult<QRCodeVO> } 返回类型
     * @Description: 2021/11/09 18:02:19 根据代理人身份id查询二维码
     */
    @PostMapping("/getQRCodeByAgentIdentityId")
    JsonResult<QRCodeVO> getQRCodeByAgentIdentityId(@RequestBody Long agentIdentityId);
}
