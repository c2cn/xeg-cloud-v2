package com.xeg.apps.common.app.user.controller;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.server.FeignReference;
import com.xeg.servers.user.api.UserService;
import com.xeg.servers.user.bean.dto.CheckInviteCodeNumberDTO;
import com.xeg.servers.user.bean.dto.LoginDTO;
import com.xeg.servers.user.bean.dto.RegistryDTO;
import com.xeg.servers.user.bean.dto.SendSmsDTO;
import com.xeg.servers.user.bean.vo.RegistryVO;
import com.xeg.servers.user.bean.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xulp
 * @version v1.0.0
 * @date 2021年11月4日 上午10:54:48
 * @Description 用户登录注册相关API UserController.java
 * Modification History:
 * Date                         Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2021年11月4日 上午10:54:48       xulp            v1.0.0           Created
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录注册相关API")
public class UserController {

    @Autowired
    private UserValidate userValidate;

    @FeignReference
    private UserService userService;

    @ApiOperation(value = "发送验证码接口")
    @PostMapping(value = "/sms/send")
    public JsonResult<String> sendSms(@Valid SendSmsDTO dto) {
        userValidate.sendSmsValidate(dto.getPhone());
        return userService.sendSms(dto);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/registry")
    public JsonResult<RegistryVO> registry(@Valid RegistryDTO dto) {
        userValidate.registryValidate(dto.getPhone(), dto.getBirthDate());
        return userService.registry(dto);
    }


    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public JsonResult<UserLoginVO> login(@Valid LoginDTO dto) {
        return userService.login(dto);
    }

    @ApiOperation(value = "校验代理邀请码对应人数")
    @PostMapping(value = "/check/number")
    public JsonResult<Boolean> checkInviteCodeNumber(@Valid CheckInviteCodeNumberDTO dto) {
        return userService.checkInviteCodeNumber(dto);
    }

}
