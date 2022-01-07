package com.xeg.servers.base.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.vo.SystemConfigVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "server-base", path = "/feign/base", contextId = "base")
public interface BaseService {

    /**
     *  根据key查询系统配置
     */
    @RequestMapping("getSystemConfigByKey")
    JsonResult<SystemConfigVO> getSystemConfigByKey(@RequestBody String sysKey);
}
