package com.xeg.servers.pay.impl;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.dto.XegTextDTO;
import com.xeg.servers.pay.domain.entity.XegText;
import com.xeg.servers.pay.domain.repository.XegTextRepo;
import com.xeg.servers.user.pay.api.PayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/pay")
public class PayServiceImpl implements PayService {

    @Autowired
    private XegTextRepo xegTextRepo;


    /**
     * 测试方法
     */
    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("PayService：" + dto.getId());
    }

    /**
     * 测试Mysql
     */
    @Override
    public JsonResult<String> testMysql(XegTextDTO dto) {
        return JsonResult.success("ChatService：" + xegTextRepo.save(BeanUtils.copyObject(dto, new XegText())));
    }
}
