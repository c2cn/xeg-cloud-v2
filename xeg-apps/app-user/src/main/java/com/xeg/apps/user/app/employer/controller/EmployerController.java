package com.xeg.apps.user.app.employer.controller;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.server.FeignReference;
import com.xeg.servers.agent.api.AgentService;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.chat.api.ChatService;
import com.xeg.servers.live.api.LiveService;
import com.xeg.servers.order.api.OrderService;
import com.xeg.servers.user.pay.api.PayService;
import com.xeg.servers.push.api.PushService;
import com.xeg.servers.search.api.SearchService;
import com.xeg.servers.task.api.TaskService;
import com.xeg.servers.user.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：雇主相关接口
 * @Author：xulp
 * @Date：2021/10/25 14:47
 */
@RestController
@RequestMapping("/employer/mine")
@Api(tags = "雇主API")
public class EmployerController {
    @FeignReference
    private AgentService agentService;
    @FeignReference
    private ChatService chatService;
    @FeignReference
    private LiveService liveService;
    @FeignReference
    private OrderService orderService;
    @FeignReference
    private PayService payService;
    @FeignReference
    private PushService pushService;
    @FeignReference
    private TaskService taskService;
    @FeignReference
    private UserService userService;
    @FeignReference
    private SearchService searchService;


    @ApiOperation("雇主Controller测试服务接口")
    @PostMapping(value = "/testServerStart")
    public JsonResult<String> test(@RequestBody IdStringDTO id) {
        StringBuilder builder = new StringBuilder();
        builder.append(agentService.testServerStart(id).getData());
        builder.append(chatService.testServerStart(id).getData());
        builder.append(liveService.testServerStart(id).getData());
        builder.append(orderService.testServerStart(id).getData());
        builder.append(payService.testServerStart(id).getData());
        builder.append(pushService.testServerStart(id).getData());
        builder.append(taskService.testServerStart(id).getData());
        builder.append(userService.testServerStart(id).getData());
        builder.append(searchService.testServerStart(id).getData());
        return JsonResult.success(builder.toString());
    }

}
