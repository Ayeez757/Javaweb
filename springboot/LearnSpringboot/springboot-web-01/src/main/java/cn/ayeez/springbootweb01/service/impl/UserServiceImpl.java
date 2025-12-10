package cn.ayeez.springbootweb01.service.impl;

import cn.ayeez.springbootweb01.dao.UserDao;
import cn.ayeez.springbootweb01.dao.impl.UserDaoImpl;
import cn.ayeez.springbootweb01.javabean.User;
import cn.ayeez.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {

        ArrayList<String> lines = userDao.getUserData();

        List<cn.ayeez.springbootweb01.javabean.User> userList = lines.stream().map(line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);
            String userName = split[1];
            String password = split[2];
            String name = split[3];
            Integer age = Integer.parseInt(split[4]);
            LocalDateTime registerTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new cn.ayeez.springbootweb01.javabean.User(id, userName, password, name, age, registerTime);
        }).collect(Collectors.toList());

        return userList;
    }
}
