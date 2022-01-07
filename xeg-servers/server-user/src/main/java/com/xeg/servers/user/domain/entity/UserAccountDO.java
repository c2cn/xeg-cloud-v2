package com.xeg.servers.user.domain.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("user_account")
public class UserAccountDO implements Serializable {
    private static final long serialVersionUID=1L;
    
    @TableId(value = "id")
    private Long id;
	
    @TableField("name")
    private String name;
    
    @TableField("phone")
    private Long phone;
    
}
