package com.xeg.servers.user.bean.vo;

import com.xeg.servers.agent.bean.vo.UserIdentityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户登录展示对象
 *
 * @author xulp
 * @since 2021/10/29 19:02
 */
@Data
@ApiModel(value = "用户登录展示对象", description = "用户登录展示对象")
public class UserLoginVO implements Serializable {
    private static final long serialVersionUID = 5323945082016608510L;

    @ApiModelProperty(value = "用户登录token")
    private String token;

    @ApiModelProperty(value = "用户登录类型 1工人 2雇主")
    private Integer userType;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "用户编号字符串-工人Id+W/雇主Id+E")
    private String userIdStr;

    @ApiModelProperty(value = "代理编号")
    private Long agentId;

    @ApiModelProperty(value = "工人登录信息")
    private WorkerLoginVO workerLogin;

    @ApiModelProperty(value = "雇主登录信息")
    private EmployerLoginVO employerLogin;

    @ApiModelProperty(value = "用户身份列表")
    private List<UserIdentityVO> userIdentities;

    @ApiModelProperty(value = "用户邀请码")
    private String inviteCode;

    @ApiModelProperty(value = "冻结状态 0未冻结 1预冻结 2冻结")
    private Integer freezeStatus;

    @ApiModelProperty(value = "禁用状态 0禁用 1预禁用 2禁用")
    private Integer disableStatus;

    @ApiModelProperty(value = "当前用户二级代理的邀请码")
    private String secondAgentInviteCode;

}
