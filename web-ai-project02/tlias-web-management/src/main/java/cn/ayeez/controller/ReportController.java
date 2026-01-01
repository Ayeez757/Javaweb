package cn.ayeez.controller;

import cn.ayeez.pojo.JobOption;
import cn.ayeez.pojo.Result;
import cn.ayeez.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private EmpService empService;


    @GetMapping("/empJobData")
    public Result getEmpJopData() {
        JobOption JobOption = empService.getEmpJopData();
        return Result.success(JobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("获取员工性别数据");
        List<Map<String,Object>> empGenderData = empService.getEmpGenderData();
        return Result.success(empGenderData);
    }
}
