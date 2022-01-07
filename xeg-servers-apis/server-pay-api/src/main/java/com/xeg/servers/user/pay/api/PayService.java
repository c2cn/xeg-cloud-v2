package com.xeg.servers.user.pay.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.dto.XegTextDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "server-pay", path = "/feign/pay", contextId = "pay")
public interface PayService {
    /**
     * 测试服务启动
     *
     * @return
     */
    @PostMapping("/testServerStart")
    JsonResult<String> testServerStart(@RequestBody IdStringDTO dto);

    /**
     * 测试Mysql
     *
     * @return
     */
    @PostMapping("/testMysql")
    JsonResult<String> testMysql(@RequestBody XegTextDTO dto);
}
