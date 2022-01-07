package com.xeg.apps.employer.app.controller;

import com.xeg.cores.base.http.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：雇主订单相关接口
 * @Author：xulp
 * @Date：2021/10/25 14:47
 */
@RestController
@RequestMapping("/mine")
@Api(tags = "雇主个人信息相关API")
public class EmployerController {


    @ApiOperation("雇主个人信息Controller测试接口")
    @PostMapping(value = "/test")
    public JsonResult<String> test() {
        return JsonResult.success("OK");
    }

}
