package com.xeg.admin.forum.controller;

import com.xeg.cores.base.http.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName：com.xiaoergekeji.admin.forum.ontroller
 * @ClassName：AdminController
 * @Description：论坛管理端相关接口
 * @Author：xulp
 * @Date：2021/10/25 14:52
 */

@RestController
@RequestMapping("/forum")
@Api(tags = "论坛管理端API")
public class ForumAdminController {


    @ApiOperation(value = "论坛管理端Controller测试接口")
    @PostMapping(value = "/test")
    public JsonResult<String> test() {
        return JsonResult.success("OK");
    }
}
