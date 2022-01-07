package com.xeg.cores.base.http;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description //TODO
 * @Author Zhongkun Zhang
 * @Date 2021/5/28 14:24
 * @Version 1.0
 */
@Data
public class CredentialsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bucket;
    private String region;
    private String securityToken;
    private String accessKeySecret;
    private String accessKeyId;
    private String expiration;
    private long durationSeconds;
}
