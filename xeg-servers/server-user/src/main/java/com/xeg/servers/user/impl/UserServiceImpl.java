package com.xeg.servers.user.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xeg.cores.base.exception.ServiceException;
import com.xeg.cores.base.exception.enums.ThrowUserException;
import com.xeg.cores.base.http.JsonResult;
import com.xeg.cores.base.http.JsonResultUtils;
import com.xeg.cores.base.sms.SendSms;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.cores.base.utils.UUIDUtils;
import com.xeg.cores.server.FeignReference;
import com.xeg.servers.agent.api.AgentService;
import com.xeg.servers.agent.bean.enums.AgentTypeEnum;
import com.xeg.servers.agent.bean.enums.PlatformAgentEnum;
import com.xeg.servers.agent.bean.vo.AgentVO;
import com.xeg.servers.agent.bean.vo.UserIdentityVO;
import com.xeg.servers.base.api.BaseService;
import com.xeg.servers.base.bean.dto.IdStringDTO;
import com.xeg.servers.base.bean.enums.IsDelEnum;
import com.xeg.servers.base.bean.enums.SystemConfigKeyEnum;
import com.xeg.servers.base.bean.vo.SystemConfigVO;
import com.xeg.servers.qrcode.api.QRCodeService;
import com.xeg.servers.qrcode.bean.vo.QRCodeVO;
import com.xeg.servers.user.api.UserService;
import com.xeg.servers.user.bean.dto.CheckInviteCodeNumberDTO;
import com.xeg.servers.user.bean.dto.LoginDTO;
import com.xeg.servers.user.bean.dto.RegistryDTO;
import com.xeg.servers.user.bean.dto.SendSmsDTO;
import com.xeg.servers.user.bean.enums.*;
import com.xeg.servers.user.bean.vo.RegistryVO;
import com.xeg.servers.user.bean.vo.UserInfoVO;
import com.xeg.servers.user.bean.vo.UserLoginVO;
import com.xeg.servers.user.bean.vo.WorkerLoginVO;
import com.xeg.servers.user.cache.UserCacheOperation;
import com.xeg.servers.user.domain.entity.*;
import com.xeg.servers.user.domain.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.management.resources.agent;

import java.util.List;


/**
 * @author xulp
 * @version v1.0.0
 * @Date 2021/11/9 17:18
 * @Description 用户服务impl
 * UserService
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/9 17:18 xulp v1.0.0 Created
 */
@Slf4j
@RestController
@RequestMapping("/feign/user")
public class UserServiceImpl implements UserService {
    @FeignReference
    private AgentService agentService;
    @FeignReference
    private BaseService baseService;
    @FeignReference
    private QRCodeService qrCodeService;

    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private UserCacheOperation userCacheOperation;
    @Autowired
    private WorkerInfoRepo workerInfoRepo;
    @Autowired
    private EmployerInfoRepo employerInfoRepo;
    @Autowired
    private UserTokenRepo userTokenRepo;
    @Autowired
    private UserAgentRepo userAgentRepo;
    @Autowired
    private UserIllegalRosterRepo userIllegalRosterRepo;

    @Override
    public JsonResult<String> testServerStart(IdStringDTO dto) {
        return null;
    }

    @Override
    public JsonResult<String> sendSms(SendSmsDTO dto) {
        String phone = dto.getPhone();
        int type = dto.getType();
        UserInfo userInfo = this.getUserInfoByPhone(phone);
        // 1 登录 2 修改登录密码
        if (type == SendSmsTypeEnum.LOGIN.getValue() || type == SendSmsTypeEnum.CHANGE_PWD.getValue()) {
            // 校验该手机号是否已注册，如果没有注册，提示用户注册
            if (ObjectUtil.isEmpty(userInfo)) {
                throw new ServiceException(ThrowUserException.PHONE_NOT_FOUND_ERROR);
            }
        }
        // 3.注册/修改手机号验证码新手机号是否已注册
        if (type == SendSmsTypeEnum.REGISTER.getValue() && !ObjectUtil.isEmpty(userInfo)) {
            throw new ServiceException(ThrowUserException.PHONE_REGISTRY_ERROR);
        }

        //60秒内不可重复发送验证码
        if (userCacheOperation.readSmsCodeInterval(phone)) {
            throw new ServiceException(ThrowUserException.CODE_REPEAT_ERROR);
        }
        String code = RandomUtil.randomNumbers(6);
        //验证码写入缓存
        userCacheOperation.writeSms(phone, code);
        // 保存短信发送记录
//        Sms sms = new Sms();
//        sms.setPhone(phone);
//        sms.setSmsCode(code);
//        sms.setStatus(0);
//        smsDao.insert(sms);
        new SendSms().send(phone, code);
        return JsonResultUtils.success(code);
    }


    /**
     * @param inviteCode 邀请码
     * @param phone      手机号
     * @param smsCode    短信验证码
     * @return {@link AgentVO } 返回类型
     * @Description: 2021/11/09 17:33:61 校验用户注册合法性
     */
    private AgentVO checkRegisterValidity(String inviteCode, String phone, String smsCode) {
        this.checkSms(phone, smsCode);
        // 验证手机号是否注册过
        UserInfo userInfo = this.getUserInfoByPhone(phone);
        if (null != userInfo) {
            throw new ServiceException(ThrowUserException.PHONE_REGISTRY_ERROR);
        }

        // 验证代理邀请码是否正确
        AgentVO agentVO = agentService.getAgentByInviteCode(inviteCode).getData();
        if (ObjectUtil.isEmpty(agentVO)) {
            throw new ServiceException("代理邀请码不正确");
        }
        return agentVO;
    }

    /**
     * @param userInfo 用户信息
     * @param smsCode  短信验证码
     * @param agentVO  代理信息
     * @return {@link JsonResult<RegistryVO> } 返回类型
     * @Description: 2021/11/09 17:33:56 用户注册(数据落地)
     */
    private JsonResult<RegistryVO> userRegister(UserInfo userInfo, String smsCode, AgentVO agentVO) {
        String phone = userInfo.getPhone();
        Long agentId = agentVO.getAgentId();
        // 添加用户注册信息
        userInfo.setInviteCode(RandomUtil.randomStringUpper(6));
        userInfo.setAgentId(agentId);
        userInfoRepo.save(userInfo);
        Long userId = userInfo.getId();
        // 信用分
        int creditScore = 12;
        SystemConfigVO creditScoreVO = baseService.getSystemConfigByKey(SystemConfigKeyEnum.CREDIT_SCORE.getValue()).getData();
        if (!ObjectUtil.isEmpty(creditScoreVO)) {
            creditScore = Integer.parseInt(creditScoreVO.getValues().get(0).getValue());
        }
        String nickname = "用户" + phone.substring(7);
        // 工人个人信息
        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setNickname(nickname);
        workerInfo.setCreditScore(creditScore);
        workerInfo.setCity("");
        // 工人头像
        String workerHeadUrl = "https://xiaoerge.oss-cn-beijing.aliyuncs.com/head/worker.png";
        SystemConfigVO workerHeadVO = baseService.getSystemConfigByKey(SystemConfigKeyEnum.WORKER_HEAD.getValue()).getData();
        if (!ObjectUtil.isEmpty(workerHeadVO)) {
            workerHeadUrl = workerHeadVO.getValues().get(0).getValue();
        }
        workerInfo.setHeadImg(workerHeadUrl);
        workerInfo.setUserId(userId);
        workerInfoRepo.save(workerInfo);
        // 雇主个人信息
        EmployerInfo employerInfo = new EmployerInfo();
        employerInfo.setNickname(nickname);
        employerInfo.setCreditScore(creditScore);
        employerInfo.setCity("");

        // 雇主头像
        String employerHeadUrl = "https://xiaoerge.oss-cn-beijing.aliyuncs.com/head/boss.png";
        SystemConfigVO employerHeadVO = baseService.getSystemConfigByKey(SystemConfigKeyEnum.EMPLOYER_HEAD.getValue()).getData();
        if (!ObjectUtil.isEmpty(employerHeadVO)) {
            employerHeadUrl = employerHeadVO.getValues().get(0).getValue();
        }
        employerInfo.setUserId(userId);
        employerInfo.setHeadImg(employerHeadUrl);
        employerInfoRepo.save(employerInfo);
        // 添加用户token 信息
        UserToken userToken = new UserToken();
        userToken.setUserId(userId);
        // 添加工人token信息
        userToken.setToken(UUIDUtils.shortUuid());
        userToken.setType(UserTypeEnum.WORKER.getValue());
        userTokenRepo.save(userToken);
        // 添加雇主token信息
        userToken.setToken(UUIDUtils.shortUuid());
        userToken.setType(UserTypeEnum.EMPLOYER.getValue());
        userTokenRepo.save(userToken);
        if (AgentTypeEnum.SECOND.getValue().equals(agentVO.getAgentType())) {
            //添加用户上级代理
            UserAgent userAgent = new UserAgent();
            userAgent.setUserId(userInfo.getId());
            userAgent.setAgentIdentityId(agentVO.getAgentIdentityId());
            userAgent.setType(AgentIdentityTypeEnum.MARKET.getValue());
            userAgentRepo.save(userAgent);
            // 代理对应注册用户数+1
            userCacheOperation.incrAgentRegistryNum(userInfo.getRegisteredType(), agentId);
        }
        //todo 初始化用户统计信息

        // 删除验证码
        userCacheOperation.removeSmsCode(phone);
        return JsonResultUtils.success(BeanUtils.copyObject(userInfo, new RegistryVO()));
    }

    @Override
    public JsonResult<UserLoginVO> login(@RequestBody LoginDTO dto) {
        String phone = dto.getPhone();
        Integer loginWay = dto.getLoginWay();
        Integer userType = dto.getUserType();
        //获取用户信息，验证用户是否存在
        UserInfo userInfo = this.getUserInfoByPhone(phone);
        if (ObjectUtil.isEmpty(userInfo)) {
            throw new ServiceException(ThrowUserException.PHONE_NOT_FOUND_ERROR);
        }
        // 判断用户是否被禁用
        if (userInfo.getIsBlack() > IsBlackEnum.NO.getValue()) {
            throw new ServiceException(ThrowUserException.USER_DISABLE_ERROR);
        }
        // 两种不同方式登录分别验证账户是否存在
        if (LoginWayEnum.SMS.getValue().equals(loginWay)) {
            // 校验手机号+验证码
            this.checkSms(phone, dto.getSmsCode());
            userCacheOperation.readSmsCode(phone);
        } else if (LoginWayEnum.PWS.getValue().equals(loginWay)
                && !dto.getPassword().equals(userInfo.getPassword())) {
            // 校验账号密码
            throw new ServiceException(ThrowUserException.PASSWORD_ERROR);
        }
        Long userId = userInfo.getId();
        //校验用户禁用
        this.checkUserDisabled(userType, userId);
        UserLoginVO vo = new UserLoginVO();
        // 生成新的token
        String token = UUIDUtils.shortUuid();
        vo.setToken(token);
        vo.setUserId(userId);
        vo.setAgentId(userInfo.getAgentId());
        vo.setUserType(userType);
        //两个不同身份登录，获取不同个人信息
        if (UserTypeEnum.WORKER.getValue().equals(userType)) {
            WorkerInfo workerInfo = this.getWorkerInfoByUserId(userId);
            // 获取工人登录返回信息
            vo.setWorkerLogin(BeanUtils.copyObject(workerInfo, new WorkerLoginVO()));
            vo.setUserIdStr(userId + "W");
        }
        if (UserTypeEnum.WORKER.getValue().equals(userType)) {
            EmployerInfo employerInfo = this.getEmployerInfoByUserId(userId);
            // 获取工人登录返回信息
            vo.setWorkerLogin(BeanUtils.copyObject(employerInfo, new WorkerLoginVO()));
            vo.setUserIdStr(userId + "E");
        }
//        //TODO 目前使用socket,后期整改
//        //同一个手机号工人雇主不可同时登陆
//        String workerIdStr = String.format("%dW", getWorkerInfoByUserId(userInfo.getUserId()).getWorkerId());
//        //检查是否在在另外一设备登录,若存在,另外一端下线并通知在其他端登录
//        if (!CheckParamsUtil.isEmpty(messageCacheOperation.getSocket(workerIdStr))) {
//            //发送socket,通知旧设备被迫下线
//            socketService.pushMessage(new PushParam(workerIdStr, LivePushTypeEnum.MSG_5004.value, new ConcurrentHashMap<>()));
//        }
//        String employerIdStr = String.format("%dE", getEmployerInfoByUserId(userInfo.getUserId()).getEmployerId());
//        //检查是否在在另外一设备登录,若存在,另外一端下线并通知在其他端登录
//        if (!CheckParamsUtil.isEmpty(messageCacheOperation.getSocket(employerIdStr))) {
//            //发送socket,通知旧设备被迫下线
//            socketService.pushMessage(new PushParam(employerIdStr, LivePushTypeEnum.MSG_5004.value, new ConcurrentHashMap<>()));
//        }

        // 修改用户对应角色token
        LambdaUpdateWrapper<UserToken> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(UserToken::getUserId, userId)
                .eq(UserToken::getType, userType)
                .set(UserToken::getToken, token);
        userTokenRepo.update(updateWrapper);
        //判断当前用户是否有特殊身份
        if (IdentityStatusEnum.SPECIAL.getValue().equals(userInfo.getIdentityStatus())) {
            JsonResult<List<UserIdentityVO>> jsonResult = agentService.getUserIdentityListByPhone(phone);
            /**
             * 异常抛出必要时，可使用assertOK()方法中断程序，抛出调用的feign接口异常
             */
            jsonResult.assertOK();
            /**
             * 不需要抛出异常中断程序时，获取feign接口返回的jsonResult中的data，判断data是否为null值即可
             * （调用feign过程中，feign接口报错异常不会抛出，程序不会中断）
             */
            List<UserIdentityVO> identityVOS = jsonResult.getData();
            if (!ObjectUtil.isEmpty(identityVOS)) {
                vo.setUserIdentities(identityVOS);
            }
        }
        //根据用户id获取上级代理的邀请码
        String secondAgentInviteCode = agentService.getAgentInviteCodeByUserId(userId).getData();
        //判断不存在上级代理的邀请码，则设置为平台二级代理的邀请码
        if (ObjectUtil.isEmpty(secondAgentInviteCode)) {
            secondAgentInviteCode = agentService.getAgentInviteCodeByPhone(PlatformAgentEnum.SECOND.getValue()).getData();
        }
        vo.setSecondAgentInviteCode(secondAgentInviteCode);
        LambdaQueryWrapper<UserToken> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserToken::getUserId, userId);
        List<UserToken> userTokens = userTokenRepo.list(wrapper);
        for (UserToken oldToken : userTokens) {
            userCacheOperation.delUserToken(oldToken.getToken());
        }
        userCacheOperation.writeUserToken(token, vo);

        return JsonResultUtils.success(vo);
    }

    @Override
    public JsonResult<Boolean> checkInviteCodeNumber(CheckInviteCodeNumberDTO dto) {
        AgentVO agentVO = agentService.getAgentByInviteCode(dto.getCode()).getData();
        if (ObjectUtil.isEmpty(agentVO)) {
            throw new ServiceException(ThrowUserException.INVITE_CODE_ERROR);
        }
        Long agentId = agentVO.getAgentId();
        Long agentIdentityId = agentVO.getAgentIdentityId();
        QRCodeVO qrCodeVO = qrCodeService.getQRCodeByAgentIdentityId(agentIdentityId).getData();
        if (ObjectUtil.isEmpty(qrCodeVO)) {
            throw new ServiceException(ThrowUserException.INVITE_CODE_ERROR);
        }
        // 工人注册人数
        Long workerNum = userCacheOperation.readAgentRegistryNum(UserTypeEnum.WORKER.getValue(), agentId);
        // 雇主注册人数
        Long employerNum = userCacheOperation.readAgentRegistryNum(UserTypeEnum.EMPLOYER.getValue(), agentId);
        Boolean result = true;
        if (UserTypeEnum.EMPLOYER.getValue().equals(dto.getUserType())) {// 雇主注册
            // 工人+雇主注册人数大于最大邀请书,不可注册
            if (workerNum + employerNum >= qrCodeVO.getMaxNumber()) {
                result = false;
            }
        }
        // 工人注册人数小于最小邀请数,可以随意注册
        if (workerNum <= qrCodeVO.getMinNumber()) {
            result = true;
        }
        // 工人+雇主注册人数大于最大邀请数,不可注册
        if ((workerNum + employerNum) >= qrCodeVO.getMaxNumber()) {
            result = false;
        }
        // 工人注册人数>=雇主的N倍
        if (workerNum >= (employerNum * qrCodeVO.getProportion())) {
            result = false;
        }
        return JsonResultUtils.success(result);
    }

    @Override
    @ShardingTransactionType(TransactionType.XA)
    @Transactional
    public JsonResult<RegistryVO> registry(RegistryDTO dto) {
        String inviteCode = dto.getInviteCode();
        String phone = dto.getPhone();
        String smsCode = dto.getSmsCode();
        AgentVO agentVO = this.checkRegisterValidity(inviteCode, phone, smsCode);
        UserInfo userInfo = BeanUtils.copyObject(dto, new UserInfo());
        assert userInfo != null;
        userInfo.setId(Long.parseLong(dto.getPhone()));
        return this.userRegister(userInfo, smsCode, agentVO);
    }

    @Override
    public JsonResult<UserInfoVO> getUserInfoByUserId(Long userId) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserInfo::getId, userId)
                .eq(UserInfo::getIsDel, IsDelEnum.NO.getValue());
        UserInfo userInfo = userInfoRepo.getById(userId);
        UserInfoVO vo = BeanUtils.copyObject(userInfo, new UserInfoVO());
        vo.setUserId(userInfo.getId());
        return JsonResultUtils.success(vo);
    }

    /**
     * @param userType 用户类型 1工人 2雇主
     * @param userId   用户编号
     * @Description: 2021/11/09 17:33:97 校验用户禁用
     */
    public void checkUserDisabled(Integer userType, Long userId) {
        LambdaQueryWrapper<UserIllegalRoster> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserIllegalRoster::getUid, userId)
                .eq(UserIllegalRoster::getUserType, userType)
                .eq(UserIllegalRoster::getType, UserIllegalTypeEnum.DISABLE.getValue())
                .eq(UserIllegalRoster::getIsDel, IsDelEnum.NO.getValue());
        UserIllegalRoster userIllegalRoster = userIllegalRosterRepo.getOne(wrapper);
        if (!ObjectUtil.isEmpty(userIllegalRoster)) {
            throw new ServiceException(ThrowUserException.PHONE_IS_BLACK_ERROR);
        }
    }


    /**
     * @param phone 手机号
     * @return {@link UserInfo } 返回类型
     * @Description: 2021/11/09 17:32:47 根据手机号查询用户信息
     */
    private UserInfo getUserInfoByPhone(String phone) {
        //id生成规则
        Long id = Long.parseLong(phone);
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserInfo::getId, id)
                .eq(UserInfo::getIsDel, IsDelEnum.NO.getValue());
        return userInfoRepo.getOne(wrapper);
    }

    /**
     * @param userId 用户编号
     * @return {@link WorkerInfo } 返回类型
     * @Description: 2021/11/09 17:32:41 根据用户编号查询工人信息
     */
    private WorkerInfo getWorkerInfoByUserId(Long userId) {
        LambdaQueryWrapper<WorkerInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(WorkerInfo::getUserId, userId)
                .eq(WorkerInfo::getIsDel, IsDelEnum.NO.getValue());
        return workerInfoRepo.getOne(wrapper);
    }

    /**
     * @param userId 用户编号
     * @return {@link EmployerInfo } 返回类型
     * @Description: 2021/11/09 17:32:99 根据用户编号查询雇主信息
     */
    private EmployerInfo getEmployerInfoByUserId(Long userId) {
        LambdaQueryWrapper<EmployerInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(EmployerInfo::getUserId, userId)
                .eq(EmployerInfo::getIsDel, IsDelEnum.NO.getValue());
        return employerInfoRepo.getOne(wrapper);
    }

    /**
     * @param phone   手机号
     * @param smsCode 短信验证码
     * @Description: 2021/11/09 17:33:83 校验短信验证码
     */
    private void checkSms(String phone, String smsCode) {
        String smsCodeObj = userCacheOperation.readSmsCode(phone);
        if (ObjectUtil.isEmpty(smsCodeObj) || !smsCode.equals(smsCodeObj)) {
            throw new ServiceException(ThrowUserException.CODE_ERROR);
        }
    }
}
