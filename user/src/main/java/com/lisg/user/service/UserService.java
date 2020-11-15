package com.lisg.user.service;

import common.entity.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public List<User> getUsers(Long userId, String userName, String email, String phone, String idCardType, String idCardNum);
}
