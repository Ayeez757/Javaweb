package cn.ayeez.service;

import cn.ayeez.pojo.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmpService {


    /**
     * 分页查询员工信息
     * @param empqueryparam
     * @return
     */
    //    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empqueryparam);

    /**
     * 保存员工信息
     * @param emp
     */
    void save(Emp emp);

    /**
     * 批量删除员工信息
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 获取各个职位数量
     * @return
     */
    JobOption getEmpJopData();

    /**
     * 获取性别人数统计数据
     * @return
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 登录
     * @return
     */
    LoginInfo login(Emp emp);
}

