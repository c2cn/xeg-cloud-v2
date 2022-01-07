package com.xeg.cores.base.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ArchieDing
 * @since 2020/09/08
 */
@Data
public class TenantUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tenant;
    private String account;
    private Long userId;
    private String userName;
    private String token;
}
