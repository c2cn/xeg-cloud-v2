package com.xeg.apps.worker.app.controller;

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
@RequestMapping("/mine")
@Api(tags = "工人个人信息相关API")
public class WorkerController {


    @ApiOperation("工人个人信息Controller测试接口")
    @PostMapping(value = "/test")
    public JsonResult<String> test() {
        return JsonResult.success("OK");
    }

}
