package cn.ayeez.springbootweb01.dao.impl;

import cn.ayeez.springbootweb01.dao.UserDao;
import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;

@Component
public class UserDaoImpl implements UserDao {


    @Override
    public ArrayList<String> getUserData() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, "utf-8", new ArrayList<>());
        return lines;
    }
}
