package cn.ayeez.controller;

import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.LoginInfo;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    EmpService empService;

    @RequestMapping
    public Result login(@RequestBody Emp emp){
        log.info("登录，参数：{}",emp);
        LoginInfo loginInfo =empService.login(emp);
        return loginInfo == null ? Result.error("用户名或密码错误") : Result.success(loginInfo);
    }
}
