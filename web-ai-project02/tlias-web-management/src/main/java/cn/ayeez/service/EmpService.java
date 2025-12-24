package cn.ayeez.service;

import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.EmpQueryParam;
import cn.ayeez.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {


//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
PageResult<Emp> page(EmpQueryParam empqueryparam);

void save(Emp emp);

}

