package com.xeg.servers.agent.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.agent.bean.vo.AgentVO;
import com.xeg.servers.agent.bean.vo.UserIdentityVO;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "server-agent", path = "/feign/agent", contextId = "agent")
public interface AgentService {

    /**
     * @param dto dto
     * @return {@link JsonResult<String> } 返回类型
     * @Description: 2021/11/04 18:04:67 测试服务器开始
     */
    @PostMapping("/testServerStart")
    JsonResult<String> testServerStart(@RequestBody IdStringDTO dto);


    /**
     * @param inviteCode 代理邀请码
     * @return {@link JsonResult<AgentVO> } 返回类型
     * @Description: 2021/11/04 18:05:70 根据邀请码查询代理信息
     */
    @PostMapping("/getAgentByInviteCode")
    JsonResult<AgentVO> getAgentByInviteCode(@RequestBody String inviteCode);

    /**
     * @param phone 电话
     * @return {@link JsonResult<UserIdentityVO> } 返回类型
     * @Description: 2021/11/04 18:08:80 通过电话获得用户身份列表
     */
    @PostMapping("/getUserIdentityListByPhone")
    JsonResult<List<UserIdentityVO>> getUserIdentityListByPhone(@RequestBody String phone);

    /**
     * @param userId 用户id 参数
     * @return {@link JsonResult<String> } 返回类型
     * @Description: 2021/11/04 18:23:94 通过用户id获得代理邀请码的
     */
    @PostMapping("/getAgentInviteCodeByUserId")
    JsonResult<String> getAgentInviteCodeByUserId(@RequestBody Long userId);


    /**
     * @param phone 电话 参数
     * @return {@link JsonResult<String> } 返回类型
     * @Description: 2021/11/04 18:28:36 通过手机号获得代理邀请码
     */
    @PostMapping("/getAgentInviteCodeByPhone")
    JsonResult<String> getAgentInviteCodeByPhone(@RequestBody String phone);


}
