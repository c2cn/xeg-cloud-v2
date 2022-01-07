package com.xeg.servers.search.impl;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.search.api.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@Slf4j
@RestController
@RequestMapping("/feign/search")
public class SearchServiceImpl implements SearchService {

    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("SearchService：" + dto.getId());
    }

}
