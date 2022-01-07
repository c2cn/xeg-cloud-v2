package com.xeg.cores.base.utils;

import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.xeg.cores.base.config.ALiYunOSSConfig;
import com.xeg.cores.base.cache.HutuAliyunOssConfigrationDTO;
import com.xeg.cores.base.http.CredentialsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

/**
 * @Description 阿里云OSS工具类
 * @Author Zhongkun Zhang
 * @Date 2021/5/27 11:41
 * @Version 1.0
 */
@Component
@Slf4j
public class OSSUtils {

    @Resource
    private ALiYunOSSConfig aLiYunOSSConfig;

    /**
     * 上传文件
     *
     * @param file
     * @param ossPath
     * @return boolean
     */
    public String uploadFile(HutuAliyunOssConfigrationDTO dto, File file, String ossPath,boolean useMyDomainName) {

        try {
            if (file == null || StrUtil.isEmpty(ossPath)) {
                return null;
            }
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build( dto.getRegion() + ".aliyuncs.com",
                    dto.getAccessKeyId(), dto.getAccessKeySecret());
            PutObjectRequest putObjectRequest = new PutObjectRequest(dto.getBucket(), ossPath, file);

            // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);

            // 关闭OSSClient。
            ossClient.shutdown();
            if(useMyDomainName) {
                return dto.getMyDomainName() + "/" + ossPath;
            }else {
                return "https://" + dto.getBucket() + "." + dto.getRegion() + ".aliyuncs.com/" + ossPath;
            }
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return null;
        }
    }

    /**
     * 获取STS临时访问凭证
     */
    public CredentialsVO getTemporaryAccessCredentials(HutuAliyunOssConfigrationDTO dto) {
        try {
            // 添加endpoint。
            DefaultProfile.addEndpoint("", "Sts", dto.getEndpoint());
            // 构造default profile。
            IClientProfile profile = DefaultProfile.getProfile("", dto.getAccessKeyId(), dto.getAccessKeySecret());
            // 构造client。
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setSysMethod(MethodType.POST);
            request.setRoleArn(dto.getRoleArn());
            request.setRoleSessionName(dto.getRoleSessionName());
            // 如果policy为空，则用户将获得该角色下所有权限。
//            request.setPolicy(aLiYunOSSConfig.getPolicy().replaceFirst("/", ""));
            // 设置临时访问凭证的有效时间为3600秒。
            request.setDurationSeconds(dto.getDurationSeconds());
//            System.out.println(request.getPolicy());
            final AssumeRoleResponse response = client.getAcsResponse(request);
            // Expiration格式: 2021-05-28T04:06:02Z  转换成北京时间
            Date date = DateUtil.isoStringToDate(response.getCredentials().getExpiration());
            response.getCredentials().setExpiration(String.valueOf(date.getTime() + 8 * 60 * 60 * 1000));
            CredentialsVO vo = new CredentialsVO();
            BeanUtils.copyProperties(response.getCredentials(), vo);
            vo.setBucket(dto.getBucket());
            vo.setRegion(dto.getRegion());
            vo.setDurationSeconds(dto.getDurationSeconds());
            return vo;
        } catch (ClientException e) {
            log.error("获取STS临时访问凭证失败", e);
        }
        return null;
    }
}
