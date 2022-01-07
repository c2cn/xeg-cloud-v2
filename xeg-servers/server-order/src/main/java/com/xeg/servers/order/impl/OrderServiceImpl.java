package com.xeg.servers.order.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.dto.XegTextDTO;
import com.xeg.servers.order.api.OrderService;

/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/order")
public class OrderServiceImpl implements OrderService {


    /**
     * 测试方法
     */
    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("OrderService：" + dto.getId());
    }

    /**
     * 测试Mysql
     */
    @Override
    public JsonResult<String> testMysql(XegTextDTO dto) {
//        return JsonResult.success("OrderService：" + xegTextRepo.save(BeanUtils.copyObject(dto, new XegText())));
    	return null;
    }
}
