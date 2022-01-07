package com.xeg.cores.redis.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.xeg.cores.base.cache.HutuAliyunOssConfigrationDTO;
import com.xeg.cores.base.http.CredentialsVO;
import com.xeg.cores.base.utils.OSSUtils;
import com.xeg.cores.redis.cache.Cache;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description 阿里云OSS缓存工具
 * @Author Zhongkun Zhang
 * @Date 2021/5/28 11:32
 * @Version 1.0
 */
@Component
public class RedisALiYunOSSUtils {

    @Resource
    private Cache cache;

    @Resource
    private OSSUtils ossUtils;

    /**
     * 获取STS临时凭证
     *
     * @return
     */
    public CredentialsVO getStsCredentials(HutuAliyunOssConfigrationDTO dto) {
        Object o = cache.get("oss:ALI_OSS_TOKEN_" + dto.getBucket());
        if (ObjectUtil.isEmpty(o)) {
            CredentialsVO res = ossUtils.getTemporaryAccessCredentials(dto);
            if (res != null) {
                cache.set("oss:ALI_OSS_TOKEN_" + dto.getBucket(), res, res.getDurationSeconds());
                return res;
            }
        }
        CredentialsVO vo = JSONUtil.toBean(JSONUtil.parseObj(o), CredentialsVO.class);
        return vo;
    }
}
