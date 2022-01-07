package com.xeg.servers.order.bean.enums;

/**
	* @author xian
	* @date   2021年11月4日 下午4:08:36
	* @version v1.0.0
	* @Description	订单来源枚举
	* OrderSourceEnum.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午4:08:36       xian            v1.0.0           Created
 */
public enum OrderSourceEnum {
	GENERAL("劳务单", 1),
    CONVENE("召集单", 2),
    COMMON("常用单", 3),
    NOTICE("公告单", 4),
    LIVE("直播单", 5),
    SKILL("技工滴滴", 6);

    public final String name;
    public final int value;

    private OrderSourceEnum(String name, int value) {
        this.value = value;
        this.name = name;
    }
}
