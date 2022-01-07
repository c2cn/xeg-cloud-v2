package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xulp
 * @version v1.0.0
 * @date 2021/11/4 18:12
 * @Description ---
 * IdentityStatusEnum
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/4 18:12 xulp v1.0.0 Created
 */
@Getter
@AllArgsConstructor
public enum IdentityStatusEnum {
    ORDINARY(0, "普通身份"),
    SPECIAL(1, "特殊身份");

    private final Integer value;
    private final String remark;
}
