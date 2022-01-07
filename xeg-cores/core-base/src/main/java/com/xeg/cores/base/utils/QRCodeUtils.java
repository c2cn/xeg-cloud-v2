package com.xeg.cores.base.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xeg.cores.base.cache.HutuAliyunOssConfigrationDTO;
import com.xeg.cores.base.config.ALiYunOSSConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Description 二维码工具类
 * @Author Zhongkun Zhang
 * @Date 2021/6/22 10:49
 * @Version 1.0
 */
@Slf4j
@Component
public class QRCodeUtils extends QrCodeUtil {

    @Resource
    private ALiYunOSSConfig aLiYunOSSConfig;
    @Resource
    private OSSUtils ossUtils;

    /**
     * 解析二维码
     *
     * @param path 二维码图片地址
     * @return 解码文本
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        return decode(new File(path));
    }

    /**
     * 生成二维码并上传阿里云（通用）
     *
     * @param content  二维码内容
     * @param fileName 二维码文件名
     * @param width    二维码宽度
     * @param height   二维码高度
     * @param logoPath logo（可空）
     * @return OSS路径(不含域名) 失败为null
     */
    public String generateQRAndUpload(HutuAliyunOssConfigrationDTO dto, String content, String fileName, int width, int height, String logoPath) {
        try {
            QrConfig qrConfig = new QrConfig();
            qrConfig.setWidth(width);
            qrConfig.setHeight(height);
            qrConfig.setErrorCorrection(ErrorCorrectionLevel.M);
            if (StrUtil.isNotEmpty(logoPath)) {
                // 设置logo
                qrConfig.setImg(logoPath);
                qrConfig.setRatio(4);
            }
            File targetFile = new File(logoPath);
            File file = generate(content, qrConfig, targetFile);
            String ossPath = aLiYunOSSConfig.getQrFilePath() + System.currentTimeMillis() + "_" + fileName;
            String url = ossUtils.uploadFile(dto,file, ossPath,false);

            //TODO 上传成功后清除本地图片缓存
            file.delete();
            if (StrUtil.isNotEmpty(url)) {
                return url;
            }
        } catch (Exception e) {
            log.error("生成二维码失败", e);
        }
        return null;
    }

    /**
     * 生成一级代理二维码并上传阿里云
     *
     * @param proxyCode 代理码
     * @return OSS路径 失败为null
     */
    public String generateFirstProxyQRAndUpload(HutuAliyunOssConfigrationDTO dto,String proxyCode, String logoPath) {
        StringBuffer content = new StringBuffer();
        content.append(aLiYunOSSConfig.getQrCodeDomainNameFirst());
        // 代理码
        content.append("?x=");
        content.append(proxyCode);
        String fileName = proxyCode + aLiYunOSSConfig.getQrFormat();

        return  generateQRAndUpload(dto,content.toString(), fileName, aLiYunOSSConfig.getQrWidth(),
                aLiYunOSSConfig.getQrHeight(), logoPath);
    }

    /**
     * 生成二级代理二维码并上传阿里云
     *
     * @param proxyCode 代理码
     * @return OSS路径 失败为null
     */
    public String generateSecondProxyQRAndUpload(HutuAliyunOssConfigrationDTO dto,String proxyCode, String logoPath) {
        StringBuffer content = new StringBuffer();
        content.append(aLiYunOSSConfig.getQrCodeDomainNameSecond());
        // 代理码
        content.append("?x=");
        content.append(proxyCode);
        String fileName = proxyCode + aLiYunOSSConfig.getQrFormat();

        return generateQRAndUpload(dto,content.toString(), fileName, aLiYunOSSConfig.getQrWidth(),
                aLiYunOSSConfig.getQrHeight(), logoPath);
    }

    /**
     * 生成用户邀请二维码并上传阿里云
     *
     * @param proxyCode      代理码
     * @param invitationCode 邀请码
     * @param logoPath       logo路径
     * @return OSS路径 失败为null
     */
    public String generateInvitationQRAndUpload(HutuAliyunOssConfigrationDTO dto,String proxyCode, String invitationCode, String logoPath) {
        StringBuffer content = new StringBuffer();
        content.append(aLiYunOSSConfig.getQrCodeDomainNameUser());
        // 邀请码
        content.append("?y=");
        content.append(invitationCode);
        // 代理码
        content.append("&x=");
        content.append(proxyCode);
        String fileName = proxyCode + "_" + invitationCode + aLiYunOSSConfig.getQrFormat();
        String s = generateQRAndUpload(dto,content.toString(), fileName, aLiYunOSSConfig.getQrWidth(),
                aLiYunOSSConfig.getQrHeight(), logoPath);
        if (StrUtil.isNotEmpty(s)) {
            return s;
        }
        return null;
    }
}
