package com.xeg.cores.base.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xeg.cores.base.utils.JsonUtils;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/4/28 15:04
 */
public class SendSms {

    private static String accessKeyId;

    private static String accessKeySecret;

//    public static void main(String[] args) {
//        SendSms sendSms = new SendSms();
//        sendSms.send("15868804722", "123457");
//    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        SendSms.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        SendSms.accessKeySecret = accessKeySecret;
    }

    public String send(String phone, String code) {
        //子账户
        //用户登录名称 xegsms@1374994112569480.onaliyun.com
        //AccessKey ID LTAI4GFmzahy69m3mHBUSAfk
        //AccessKey Secret dUviRmrdj3AU9c7mTjl26VoKC5Fwi1
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GFmzahy69m3mHBUSAfk", "dUviRmrdj3AU9c7mTjl26VoKC5Fwi1");
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "小二哥干活");
        request.putQueryParameter("TemplateCode", "SMS_200185756");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(JsonUtils.toJson(response));
            return JsonUtils.toJson(response);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}

