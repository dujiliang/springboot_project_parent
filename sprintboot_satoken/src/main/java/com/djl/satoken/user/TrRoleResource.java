package com.djl.satoken.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2020/11/30
*/
@Data
@TableName(value = "tr_role_resource")
public class TrRoleResource {
    /**
     * ID
     */
     @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @TableField(value = "ROLE_ID")
    private Integer roleId;

    /**
     * 资源id
     */
    @TableField(value = "RESOURCE_ID")
    private Integer resourceId;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE")
    private Date createDate;

}