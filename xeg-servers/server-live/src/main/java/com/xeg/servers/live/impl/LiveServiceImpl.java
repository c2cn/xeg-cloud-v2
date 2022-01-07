package com.xeg.servers.live.impl;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.dto.XegTextDTO;
import com.xeg.servers.live.api.LiveService;
import com.xeg.servers.live.domain.entity.XegText;
import com.xeg.servers.live.domain.repository.XegTextRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName：com.xiaoergekeji.server.agent.server.impl
 * @ClassName：agentServiceImpl
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/live")
public class LiveServiceImpl implements LiveService {

    @Autowired
    private XegTextRepo xegTextRepo;

    /**
     * 测试方法
     */
    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("LiveService：" + dto.getId());
    }

    /**
     * 测试Mysql
     */
    @Override
    public JsonResult<String> testMysql(XegTextDTO dto) {
        return JsonResult.success("LiveService：" + xegTextRepo.save(BeanUtils.copyObject(dto, new XegText())));
    }
}
