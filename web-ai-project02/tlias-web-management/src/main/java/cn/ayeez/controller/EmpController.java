package cn.ayeez.controller;


import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.EmpQueryParam;
import cn.ayeez.pojo.PageResult;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.EmpService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

//    /**
//     *
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @GetMapping("/emps")
//    public Result emps(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name,Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
//                       ) {
//        log.info("分页查询:{}{}{}{}{}{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult = empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }

    /**
     *
     * @param empQueryParam
     * @return
     */
    @GetMapping("/emps")
    public Result emps(EmpQueryParam empQueryParam) {
        log.info("分页查询:{}",empQueryParam );
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp){

        log.info("保存员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }


    @DeleteMapping("/emps")
    public Result delete (@RequestParam List<Integer> ids){
        log.info("删除员工:{}",ids);
        empService.deleteByIds(ids);



        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询员工:{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("更新员工:{}",emp);
        empService.update(emp);


        return Result.success();
    }


}
