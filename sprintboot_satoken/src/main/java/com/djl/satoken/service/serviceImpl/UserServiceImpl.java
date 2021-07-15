package com.djl.satoken.service.serviceImpl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djl.satoken.mapper.UserMapper;
import com.djl.satoken.service.UserService;
import com.djl.satoken.user.User;
import com.djl.satoken.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: djl
 * @Date: 2021/5/18 14:21
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /***
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public R doLogin(String username, String password) {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("USER_NAME", username).eq("USER_PWD", password));
        if (CollectionUtils.isEmpty(users)) {
            return R.error("用户名或密码错误");
        }
        User user = users.get(0);
        StpUtil.setLoginId(user.getId());
        StpUtil.getSession().setAttribute("user",user);
        return R.ok(StpUtil.getTokenInfo());
    }

    /***
     * 获取用户信息
     * @return
     */
    @Override
    public R getUserInfo() {
        SaSession session = StpUtil.getSession();
        User user = session.getModel("user", User.class);
        return R.ok(user);
    }

    /***
     * 退出登录
     * @return
     */
    @Override
    public R logOut() {
        StpUtil.logout();
        return R.ok("退出系统");
    }
}
