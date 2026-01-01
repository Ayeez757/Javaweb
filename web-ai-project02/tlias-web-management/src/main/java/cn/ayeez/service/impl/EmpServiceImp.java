package cn.ayeez.service.impl;

import cn.ayeez.mapper.EmpExprMapper;
import cn.ayeez.mapper.EmpMapper;
import cn.ayeez.pojo.*;
import cn.ayeez.service.EmpService;
import cn.ayeez.utils.JwtUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.pages(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);

        List<EmpExpr> empExprList = emp.getEmpExprs();
        if (!CollectionUtils.isEmpty(empExprList)) {
            empExprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empExprList);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        if (!CollectionUtils.isEmpty(emp.getEmpExprs())) {

            emp.getEmpExprs().forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(emp.getEmpExprs());
        }
    }

    @Override
    public JobOption getEmpJopData() {
        List<Map<String, Object>> empJobData = empMapper.getEmpJobData();
        List<Object> jobname = empJobData.stream().map(item -> item.get("jobname")).toList();
        List<Object> jobcount = empJobData.stream().map(item -> item.get("num")).toList();
        JobOption jobOption = new JobOption(jobname, jobcount);
        return jobOption;
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        List<Map<String, Object>> empGenderData = empMapper.getEmpGenderData();
        return empGenderData;
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp e = empMapper.loginByUsernameAndPassword(emp);
        if (e != null) {
            log.info("登录成功，信息：{}", e);
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
             String jwt = JwtUtils.generateToken(claims);
            LoginInfo loginInfo = new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
            return loginInfo;
        }
        return null;
    }


}
