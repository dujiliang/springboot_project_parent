package com.djl.satoken.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @author: duzesheng
 * @date: 2020/11/17
 * @description: ${description}
 */
/**
    * 用户表
    */
@Data
@TableName(value = "tb_user")
public class User {
    /**
     * 用户ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * 用户密码
     */
    @TableField(value = "USER_PWD")
    private String userPwd;

    /**
     * 昵称
     */
    @TableField(value = "NICK_NAME")
    private String nickName;

    /**
     * 部门
     */
    @TableField(value = "DEPT")
    private String dept;

    /** 头像连接**/
    private String headImg;

    /** 性别**/
    private Integer gender;

    /** 手机号**/
    private String mobileNum;

    /**
     * 状态
     */

    private Integer state;

    /**
     * 创建时间
     */

    private Date createDate;

    /**
     * 修改时间
     */

    private Date updateDate;
}