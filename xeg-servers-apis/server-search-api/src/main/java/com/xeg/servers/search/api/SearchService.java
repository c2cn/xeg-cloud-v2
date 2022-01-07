package com.xeg.servers.search.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "server-search", path = "/feign/search", contextId = "search")
public interface SearchService {
    /**
     * 测试服务启动
     *
     * @return
     */
    @PostMapping("/testServerStart")
    JsonResult<String> testServerStart(@RequestBody IdStringDTO dto);

}
