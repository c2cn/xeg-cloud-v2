package com.xeg.cores.base.cache;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxx
 * @since 2021-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="HutuAliyunOssConfigration对象", description="")
public class HutuAliyunOssConfigrationDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "bucket名")
    private String bucket;

    @ApiModelProperty(value = "region")
    private String region;

    @ApiModelProperty(value = "endpoint")
    private String endpoint;

    @ApiModelProperty(value = "accessKeyId")
    private String accessKeyId;

    @ApiModelProperty(value = "accessKeySecret")
    private String accessKeySecret;

    @ApiModelProperty(value = "roleArn")
    private String roleArn;

    @ApiModelProperty(value = "roleSessionName")
    private String roleSessionName;

    @ApiModelProperty(value = "my_domain_name")
    private String myDomainName;

    @ApiModelProperty(value = "durationSeconds")
    private Long durationSeconds;
}
