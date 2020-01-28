package org.sy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sy.bean.User;
import org.sy.mapper.UserMapper;

import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser(){
        List<User> users = mapper.selectUsers();
        return users;
    }
}
