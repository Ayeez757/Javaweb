package cn.ayeez.controller;


import cn.ayeez.pojo.Dept;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result findAll() {
        List<Dept> list = deptService.findAll();
        return Result.success(list);
    }

    @DeleteMapping("/depts")
    public Result deleteById(Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping("depts")
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }


    @GetMapping("depts/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Dept depts = deptService.getById(id);
        return Result.success(depts);
    }
}
