package com.lisg.user.service.impl;

import com.lisg.user.mapper.UserMapper;
import com.lisg.user.service.UserService;
import com.lisg.user.util.PasswordUtil;
import common.constant.Const;
import common.entity.User;
import common.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-15 11:30
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        SnowflakeIdWorker sf = new SnowflakeIdWorker();
        user.setUserId(sf.nextId());
        user.setPassword(PasswordUtil.encryptSha512String(PasswordUtil.encryptMd5String(user.getPassword())));
        user.setRole(Const.UserRole.NORMAL);
        userMapper.insert(user);
    }

    @Override
    public List<User> getUsers(Long userId, String userName, String email,
                               String phone, String idCardType, String idCardNum) {
        return userMapper.selectUsers(userId, userName, email, phone, idCardType, idCardNum);
    }
}
