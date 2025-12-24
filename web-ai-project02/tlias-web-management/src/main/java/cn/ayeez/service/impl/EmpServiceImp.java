package cn.ayeez.service.impl;

import cn.ayeez.mapper.EmpExprMapper;
import cn.ayeez.mapper.EmpMapper;
import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.EmpExpr;
import cn.ayeez.pojo.EmpQueryParam;
import cn.ayeez.pojo.PageResult;
import cn.ayeez.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    EmpExprMapper empExprMapper;


//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count();
//        List<Emp> rows = empMapper.pages((page-1)*pageSize,pageSize);
//        return new PageResult<Emp>(total,rows);
//    }

//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        PageHelper.startPage(page,pageSize);
//        List<Emp> empList = empMapper.pages(name,gender,begin,end);
//        Page<Emp> p = (Page<Emp>) empList;
//        return new PageResult<>(p.getTotal(),p.getResult());
//    }

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> empList = empMapper.pages(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Transactional
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);

        List<EmpExpr> empExprList =emp.getEmpExprs();
        if(!CollectionUtils.isEmpty(empExprList)){
            empExprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empExprList);
        }
    }

}
