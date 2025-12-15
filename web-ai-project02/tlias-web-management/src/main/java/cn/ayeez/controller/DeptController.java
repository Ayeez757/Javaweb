package cn.ayeez.controller;


import cn.ayeez.pojo.Dept;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result findAll(){
        List<Dept> list  =deptService.findAll();
        return Result.success(list);
    }
}
