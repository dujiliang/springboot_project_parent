package com.djl.satoken.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.djl.satoken.service.UserService;
import com.djl.satoken.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: djl
 * @Date: 2021/5/18 10:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;


    @RequestMapping("doLogin")
    public R doLogin(String username, String password) {

        return userServiceImpl.doLogin(username,password);
    }

    @RequestMapping("getUserInfo")
    public R getUserInfo () {
        return userServiceImpl.getUserInfo();
    }


    @RequestMapping("isLogin")
    public String isLogin(String username, String password) {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("logOut")
    public R logOut() {
        return userServiceImpl.logOut();
    }


    @SaCheckLogin
    @SaCheckPermission(value = {"user-add"})
    @SaCheckRole(value = {"super-admin"})
    @RequestMapping("getBusinessList")
    public R getBusinessList () {

        return R.ok();

    }
}
