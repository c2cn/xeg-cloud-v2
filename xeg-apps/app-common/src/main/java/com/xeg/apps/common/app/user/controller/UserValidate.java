package com.xeg.apps.common.app.user.controller;

import com.xeg.cores.base.exception.ServiceException;
import com.xeg.cores.base.exception.enums.ThrowUserException;
import com.xeg.cores.base.utils.DateUtil;
import com.xeg.cores.base.utils.PhoneUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * -----
 *
 * @Author xulp
 * @since 2021/10/29 15:12
 */
@Service
public class UserValidate {

    /**
     * @param phone 手机号 参数
     * @Title: sendSmsValidate
     * @Description: 2021/11/04 16:42:88 发送验证码验证
     */
    public void sendSmsValidate(String phone) {
        this.checkPhone(phone);
    }

    /**
     * @param phone    手机号
     * @param birthday 生日 参数
     * @Title: registryValidate
     * @Description: 2021/11/04 16:41:49 登录验证
     */
    public void registryValidate(String phone, String birthday) {
        // 校验手机号
        checkPhone(phone);
        // 校验出生日期
        if (!DateUtil.isDate(birthday)) {
            throw new ServiceException("出生日期格式不正确，请使用yyyy-mm-dd格式");
        }
        // 校验年龄
        int age = DateUtil.getUserAge(birthday);
        if (age < 18 || age > 65) {
            throw new ServiceException("用户年龄不在18-65周岁范围内，不能进行注册");
        }
    }

    /**
     * @param phone 手机号 参数
     * @Title: checkPhone
     * @Description: 2021/11/04 16:42:74 检查手机号
     */
    private void checkPhone(String phone) {
        // 校验手机号
        if (!PhoneUtils.isMobile(phone)) {
            throw new ServiceException(ThrowUserException.PHONE_PATTERN_ERROR);
        }


    }
}
