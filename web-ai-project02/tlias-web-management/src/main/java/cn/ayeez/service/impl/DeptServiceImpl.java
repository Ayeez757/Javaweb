package cn.ayeez.service.impl;

import cn.ayeez.mapper.DeptMapper;
import cn.ayeez.pojo.Dept;
import cn.ayeez.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
