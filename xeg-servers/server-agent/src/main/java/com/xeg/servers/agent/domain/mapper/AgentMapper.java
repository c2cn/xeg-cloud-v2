package com.xeg.servers.agent.domain.mapper;

import com.xeg.servers.agent.bean.vo.AgentVO;
import com.xeg.servers.agent.bean.vo.UserIdentityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 代理商信息表 Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2021-10-30
 */
public interface AgentMapper {

    AgentVO getAgentByInviteCode(@Param("inviteCode") String inviteCode);

    List<UserIdentityVO> getUserIdentityListByPhone(@Param("phone") String phone);

    String getAgentInviteCodeByUserId(@Param("userId") Long userId);

    String getAgentInviteCodeByPhone(@Param("phone") String phone);
}
