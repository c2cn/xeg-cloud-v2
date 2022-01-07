package com.xeg.servers.base.bean.vo;

import cn.hutool.core.util.ObjectUtil;
import com.xeg.cores.base.utils.BeanUtils;
import com.xeg.cores.base.utils.JsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.omg.CORBA.SystemException;

import java.util.List;

/**
 * -----
 *
 * @Author xulp
 * @since 2021/11/1 17:27
 */
@Data
@ApiModel(value = "系统配置对象", description = "系统配置对象")
public class SystemConfigVO {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5196902453254598578L;

    @ApiModelProperty(value = "系统配置编号")
    private Long id;

    @ApiModelProperty(value = "配置类型 1订单 2意见反馈 3注册协议 4举报 5规则")
    private Integer sysType;

    @ApiModelProperty(value = "配置键")
    private String sysKey;

    @ApiModelProperty(value = "配置值")
    private String sysValue = "[]";

    @ApiModelProperty(value = "配置值列表")
    private List<SystemConfigValueVO> values;

    /**
     * 将字符串类型转化为集合
     */
    public void convertToList() {
        if (!ObjectUtil.isEmpty(this.sysValue)) {
            this.values = JsonUtils.toList(this.sysValue, SystemConfigValueVO.class);
        }
    }


    /**
     * 将集合类型转化为字符串
     */
    public void convertToStr() {
        if (null == this.values) {
            this.sysValue = "[]";
        }
        this.sysValue = JsonUtils.toJson(this.values);
    }
}
