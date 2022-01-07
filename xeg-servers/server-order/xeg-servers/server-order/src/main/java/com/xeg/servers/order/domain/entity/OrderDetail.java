package com.xeg.servers.order.domain.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单详细信息表
 * </p>
 *
 * @author xxx
 * @since 2021-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xeg_order_detail")
@ApiModel(value="OrderDetail对象", description="订单详细信息表")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单编号(仅短工使用)")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty(value = "工作性质  (小时工/日工/多日短工/长期工)")
    @TableField("work_property")
    private String workProperty;

    @ApiModelProperty(value = "工作开始时间")
    @TableField("work_start_time")
    private LocalDateTime workStartTime;

    @ApiModelProperty(value = "工作结束时间")
    @TableField("work_end_time")
    private LocalDateTime workEndTime;

    @ApiModelProperty(value = "预计工作时长N天")
    @TableField("work_day_duration")
    private Integer workDayDuration;

    @ApiModelProperty(value = "预计工作累计时长 单位:时")
    @TableField("cumulative_duration")
    private BigDecimal cumulativeDuration;

    @ApiModelProperty(value = "性别 0不限  1男 2女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄段 0不限  格式 18-60")
    @TableField("age")
    private String age;

    @ApiModelProperty(value = "图片 多个逗号隔开")
    @TableField("picture")
    private String picture;

    @ApiModelProperty(value = "视频")
    @TableField("video")
    private String video;

    @ApiModelProperty(value = "语音")
    @TableField("voice")
    private String voice;

    @ApiModelProperty(value = "语音长度")
    @TableField("voice_duration")
    private Integer voiceDuration;

    @ApiModelProperty(value = "考核重点")
    @TableField("inspection_focus")
    private String inspectionFocus;

    @ApiModelProperty(value = "结算方式")
    @TableField("settlement")
    private String settlement;

    @ApiModelProperty(value = "福利待遇 逗号隔开")
    @TableField("welfare")
    private String welfare;

    @ApiModelProperty(value = "公告时长 单位:秒")
    @TableField("notice_duration")
    private Integer noticeDuration;

    @ApiModelProperty(value = "大厅订单关闭时间")
    @TableField("close_time")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "技能要求")
    @TableField("skill")
    private String skill;

    @ApiModelProperty(value = "世界语音")
    @TableField("world_voice")
    private String worldVoice;

    @ApiModelProperty(value = "世界语音长度")
    @TableField("world_voice_duration")
    private Integer worldVoiceDuration;

    @ApiModelProperty(value = "保底工资 单位： 元/人/天")
    @TableField("low_wages")
    private Integer lowWages;

    @ApiModelProperty(value = "计件工资")
    @TableField("piece_wages")
    private BigDecimal pieceWages;

    @ApiModelProperty(value = "创建时间")
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
      @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "状态位 0正常 1删除")
      @TableField(value = "is_del", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "技能要求")
    @TableField("skill_name")
    private String skillName;


}
