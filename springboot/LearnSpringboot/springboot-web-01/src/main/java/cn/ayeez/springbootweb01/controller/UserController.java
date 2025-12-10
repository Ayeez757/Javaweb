package cn.ayeez.springbootweb01.controller;

import cn.ayeez.springbootweb01.javabean.User;

import java.util.List;

public interface UserController {

    public abstract List<User> list();
}
