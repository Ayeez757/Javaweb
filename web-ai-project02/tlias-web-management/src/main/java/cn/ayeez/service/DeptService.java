package cn.ayeez.service;

import cn.ayeez.pojo.Dept;

import java.util.List;

public interface DeptService {
    Dept getById(Integer id);

    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);
}
