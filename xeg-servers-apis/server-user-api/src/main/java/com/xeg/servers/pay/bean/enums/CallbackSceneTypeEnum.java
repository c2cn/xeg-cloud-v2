package com.xeg.servers.pay.bean.enums;

/**
	* @author xian
	* @date   2021年11月4日 下午3:59:15
	* @version v1.0.0
	* @Description	支付回调场景类型枚举
	* CallbackSceneTypeEnum.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午3:59:15       xian            v1.0.0           Created
 */
public enum CallbackSceneTypeEnum {
	ST10("抢单", 10),
    ST11("议价", 11),
    ST12("直播间排队", 12),
    ST13("直播间报价自荐", 13),
    ST14("补缴保证金", 14),
    ST15("缴纳保证金", 15),
    ST16("购买手机号", 16),
    ST20("发布订单", 20);

    public final String name;
    public final int value;

    private CallbackSceneTypeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
