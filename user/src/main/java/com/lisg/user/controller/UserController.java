package com.lisg.user.controller;

import com.lisg.user.service.UserService;
import com.lisg.user.util.PasswordUtil;
import common.entity.User;
import common.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-15 11:13
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity getUser(@RequestParam(value = "userId", required = false) Long userId,
                                  @RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "phone", required = false) String phone,
                                  @RequestParam(value = "idCardType", required = false) String idCardType,
                                  @RequestParam(value = "idCardNum", required = false) String idCardNum) {

        List<User> userList = userService.getUsers(userId, userName, email, phone, idCardType, idCardNum);
        return new ResponseEntity(userList, HttpStatus.OK);
    }
}
