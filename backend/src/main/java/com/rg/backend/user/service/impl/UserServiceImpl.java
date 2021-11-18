package com.rg.backend.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rg.backend.user.entity.User;
import com.rg.backend.user.mapper.UserMapper;
import com.rg.backend.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginCheck(String account, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account", account);
        wrapper.eq("password", password);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public int regAdd(String account, String password) {
        User user = new User();
        QueryWrapper nameWrapper = new QueryWrapper();
        nameWrapper.eq("account", account);
        User existingUser = userMapper.selectOne(nameWrapper);
        if (existingUser != null) {
            return 0;//0代表userName存在
        } else {
            user.setAccount(account);
            user.setPassword(password);
            int i = userMapper.insert(user);
            return i;
        }
    }

    @Override
    public User getUser(String account) {
        QueryWrapper nameWrapper = new QueryWrapper();
        nameWrapper.eq("account", account);
        User user = userMapper.selectOne(nameWrapper);
        return user;
    }

    @Override
    public int resetPass(String account, String oldPassword, String newPassword) {
        QueryWrapper nameWrapper = new QueryWrapper();
        nameWrapper.eq("account", account);
        nameWrapper.eq("password",oldPassword);
        User existingUser = userMapper.selectOne(nameWrapper);
        if (existingUser.getId() != null) {
            existingUser.setPassword(newPassword);
            userMapper.update(existingUser,nameWrapper);
            return 1;
        } else {
            return 0;
        }
    }
}
