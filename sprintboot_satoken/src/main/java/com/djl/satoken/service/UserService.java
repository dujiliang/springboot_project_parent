package com.djl.satoken.service;

import com.djl.satoken.utils.R;

/**
 * @Author: djl
 * @Date: 2021/5/18 14:19
 * @Version 1.0
 */
public interface UserService {

    /***
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    R doLogin(String username, String password);


    /***
     * 获取用户信息
     * @return
     */
    R getUserInfo();

    /***
     * 退出登录
     * @return
     */
    R logOut();
}
