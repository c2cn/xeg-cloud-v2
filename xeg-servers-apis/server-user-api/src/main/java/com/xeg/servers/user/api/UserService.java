package com.xeg.servers.user.api;

import com.xeg.cores.base.http.JsonResult;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.user.bean.dto.CheckInviteCodeNumberDTO;
import com.xeg.servers.user.bean.dto.LoginDTO;
import com.xeg.servers.user.bean.dto.RegistryDTO;
import com.xeg.servers.user.bean.dto.SendSmsDTO;
import com.xeg.servers.user.bean.vo.RegistryVO;
import com.xeg.servers.user.bean.vo.UserInfoVO;
import com.xeg.servers.user.bean.vo.UserLoginVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:18
 * @Description 用户服务
 * UserService
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:18 xulp v1.0.0 Created
 */
@FeignClient(name = "server-user", path = "/feign/user", contextId = "user")
public interface UserService {
    /**
     * @param dto dto 参数
     * @return {@link JsonResult<String> } 返回类型
     * @Description: 2021/11/09 17:27:89 测试服务启动
     */
    @PostMapping("/testServerStart")
    JsonResult<String> testServerStart(@RequestBody IdStringDTO dto);

    /**
     * @param dto dto 参数
     * @return {@link JsonResult<String> } 返回类型
     * @Description: 2021/11/04 13:11:91 发送短信
     */
    @PostMapping("/sendSms")
    JsonResult<String> sendSms(@RequestBody SendSmsDTO dto);

    /**
     * @param dto dto
     * @return {@link JsonResult<RegistryVO> } 返回类型
     * @Description: 2021/11/04 11:49:08 用户注册
     */
    @PostMapping("/registry")
    JsonResult<RegistryVO> registry(@RequestBody RegistryDTO dto);

    /**
     * @param dto dto 参数
     * @return {@link JsonResult<UserLoginVO> } 返回类型
     * @Description: 2021/11/09 17:26:26 用户登录
     */
    @PostMapping("/login")
    JsonResult<UserLoginVO> login(@RequestBody LoginDTO dto);


    /**
     * @param dto dto 参数
     * @return {@link JsonResult<Boolean> } 返回类型
     * @Description: 2021/11/09 17:24:38 校验代理邀请码对应人数
     */
    @PostMapping("/checkInviteCodeNumber")
    JsonResult<Boolean> checkInviteCodeNumber(@RequestBody CheckInviteCodeNumberDTO dto);

    /**
     * @param userId 用户id 参数
     * @return {@link JsonResult<UserInfoVO> } 返回类型
     * @Description: 2021/11/09 17:34:26 根据用户编号查询用户信息
     */
    @PostMapping("/getUserInfoByUserId")
    JsonResult<UserInfoVO> getUserInfoByUserId(@RequestBody Long userId);
}
