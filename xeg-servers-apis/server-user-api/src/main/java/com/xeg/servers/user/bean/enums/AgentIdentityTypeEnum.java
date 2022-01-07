package com.xeg.servers.user.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xulp
 * @version v1.0.0
 * @date 2021/11/4 17:06
 * @Description ---
 * AgentIdentityTypeEnum
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/4 17:06 xulp v1.0.0 Created
 */
@Getter
@AllArgsConstructor
public enum AgentIdentityTypeEnum {

    MARKET(1, "劳务市场");

    private final Integer value;
    private final String remark;
}
