package com.xeg.servers.agent.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xulp
 * @version v1.0.0
 * @date 2021/11/4 18:12
 * @Description 平台代理枚举
 * IdentityStatusEnum
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/4 18:12 xulp v1.0.0 Created
 */
@Getter
@AllArgsConstructor
public enum PlatformAgentEnum {
    FIRST("95000000000", "平台一级代理"),
    SECOND("98000000000", "平台二级代理");

    public String value;
    public String remark;

}
