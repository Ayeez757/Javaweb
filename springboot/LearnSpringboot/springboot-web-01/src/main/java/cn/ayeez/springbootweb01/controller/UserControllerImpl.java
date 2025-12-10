package cn.ayeez.springbootweb01.controller;

import cn.ayeez.springbootweb01.javabean.User;
import cn.ayeez.springbootweb01.service.UserService;
import cn.ayeez.springbootweb01.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserControllerImpl {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> list() {

        List<User> userList = userService.list();


        return userList;


    }

}
