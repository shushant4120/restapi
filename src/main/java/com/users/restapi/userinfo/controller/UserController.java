package com.users.restapi.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.restapi.userinfo.model.UserInfoPOJO;
import com.users.restapi.userinfo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userlist")
    public List<UserInfoPOJO> getUserList() {
        return userService.getUserList();
    }
}
