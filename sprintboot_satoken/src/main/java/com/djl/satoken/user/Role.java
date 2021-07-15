package com.djl.satoken.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
* Created by Mybatis Generator 2020/11/18
*/
@Data
@TableName(value = "tb_role")
public class Role {

    /**
     * 角色ID
     */
     @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名
     */
    @TableField(value = "ROLE_NAME")
    private String roleName;

    /**
     * 角色级别
     */
    @TableField(value = "ROLE_LEVEL")
    private Integer roleLevel;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;


}