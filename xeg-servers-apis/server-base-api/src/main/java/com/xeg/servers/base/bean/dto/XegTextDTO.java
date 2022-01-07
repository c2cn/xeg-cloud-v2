package com.xeg.servers.base.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxx
 * @since 2021-10-27
 */
@Data
public class XegTextDTO implements Serializable {

    private static final long serialVersionUID=1L;

    private Long bid;

    private String text;

    private Long createTime;
}
