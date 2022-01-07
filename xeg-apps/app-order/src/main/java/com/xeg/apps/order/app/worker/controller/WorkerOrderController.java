package com.xeg.apps.order.app.worker.controller;

import com.xeg.cores.base.http.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：工人订单相关接口
 * @Author：xulp
 * @Date：2021/10/25 14:47
 */
@RestController
@RequestMapping("/worker/order/")
@Api(tags = "工人订单API")
public class WorkerOrderController {


    @ApiOperation("工人订单Controller测试接口")
    @PostMapping(value = "/test")
    public JsonResult<String> test() {
        return JsonResult.success("OK");
    }

}
