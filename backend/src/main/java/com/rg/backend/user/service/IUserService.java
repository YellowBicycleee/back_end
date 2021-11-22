package com.rg.backend.user.service;

import com.rg.backend.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-18
 */
public interface IUserService extends IService<User> {
    //登录验证
    User loginCheck(String account, String password);
    //注册用户
    int regAdd(String account,String password);
    //获取用户
    User getUser(String account);
    //重置密码
    int resetPass(String account,String oldPassword,String newPassword);
    //删除用户
    int delUserByAccount(String account);
}
