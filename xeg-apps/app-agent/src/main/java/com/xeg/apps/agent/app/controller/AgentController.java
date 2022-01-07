package com.xeg.apps.agent.app.controller;

import com.xeg.cores.base.http.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName：com.xiaoergekeji.app.agent.controller
 * @ClassName：AgentController
 * @Description：代理相关接口
 * @Author：xulp
 * @Date：2021/10/25 14:47
 */
@RestController
@RequestMapping("/agent")
@Api(tags = "代理API")
public class AgentController {


    @ApiOperation("代理Controller测试接口")
    @PostMapping(value = "/test")
    public JsonResult<String> test() {
        return JsonResult.success("OK");
    }

}
