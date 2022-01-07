package com.xeg.cores.base.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ningpeng
 * @description: 用户登录信息
 * @date 2021/4/27 16:48
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements Serializable {
    private static final long serialVersionUID = 1020843375923402106L;

    private int id;

    private String name;
}
