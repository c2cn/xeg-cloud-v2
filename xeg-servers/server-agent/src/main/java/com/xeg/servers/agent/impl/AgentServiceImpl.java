package com.xeg.servers.agent.impl;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.servers.agent.api.AgentService;
import com.xeg.servers.agent.bean.vo.AgentVO;
import com.xeg.servers.agent.bean.vo.UserIdentityVO;
import com.xeg.servers.agent.domain.mapper.AgentMapper;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description：//TODO
 * @Author：xulp
 * @Date：2021/10/25 17:22
 */
@RestController
@RequestMapping("/feign/agent")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentMapper agentMapper;

    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return JsonResult.success("AgentService：" + dto.getId());
    }

    @Override
    public JsonResult<AgentVO> getAgentByInviteCode(String inviteCode) {
        return JsonResultUtils.success(agentMapper.getAgentByInviteCode(inviteCode));
    }

    @Override
    public JsonResult<List<UserIdentityVO>> getUserIdentityListByPhone(String phone) {
        return JsonResultUtils.success(agentMapper.getUserIdentityListByPhone(phone));
    }


    @Override
    public JsonResult<String> getAgentInviteCodeByUserId(Long userId) {
        return JsonResultUtils.success(agentMapper.getAgentInviteCodeByUserId(userId));
    }


    @Override
    public JsonResult<String> getAgentInviteCodeByPhone(String phone) {
        return JsonResultUtils.success(agentMapper.getAgentInviteCodeByPhone(phone));
    }
}
