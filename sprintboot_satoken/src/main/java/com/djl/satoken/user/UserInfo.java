package com.djl.satoken.user;


import lombok.Data;
import java.io.Serializable;


/**
 * @author: duzesheng
 * @date: 2020/11/19
 * @description: 当前用户
 */

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 6940880134197666290L;

    /**
     * 用户ID
     */

    private Integer id;

    /**
     * 用户名
     */

    private String userName;

    /**
     * 昵称
     */

    private String nickName;

    /**
     * 部门
     */

    private String dept;

    /**
     * 状态
     */

    private Integer state;

    /**
     * 角色级别
     */

    private Integer roleLevel;

    /**
     * 菜单资源树
     */

}
