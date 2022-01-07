package com.xeg.servers.agent.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xulp
 * @version v1.0.0
 * @date 2021/11/4 18:12
 * @Description  代理类型枚举
 * AgentTypeEnum
 * Modification History:
 * Date Author Version Description
 * ---------------------------------------------------------------------------------*
 * 2021/11/4 18:12 xulp v1.0.0 Created
 */
@Getter
@AllArgsConstructor
public enum AgentTypeEnum {
    FIRST("一级代理", 1),
    SECOND("二级代理", 2);

    private String name;
    private Integer value;

}
