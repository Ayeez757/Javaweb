package cn.ayeez.controller;


import cn.ayeez.pojo.Dept;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result findAll() {
        List<Dept> list = deptService.findAll();
        return Result.success(list);
    }

    @DeleteMapping
    public Result deleteById(Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Dept depts = deptService.getById(id);
        return Result.success(depts);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }
}
