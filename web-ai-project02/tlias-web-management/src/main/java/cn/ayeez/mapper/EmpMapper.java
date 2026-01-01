package cn.ayeez.mapper;

import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.EmpQueryParam;
import cn.ayeez.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp e left join dept d on dept_id = e.id ")
//    public long count();
//
//    @Select("select e.*,d.name from emp e left join  dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> pages(Integer start,Integer pageSize);

//    @Select("select e.*,d.name deptName from emp e left join  dept d on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> pages(EmpQueryParam empQueryParam);

    /**
     * 保存员工信息
     * @param emp
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工
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
     * 获取员工职位统计数据
     * @return
     */
    @MapKey("jobname")
    List<Map<String,Object>> getEmpJobData();

    /**
     * 获取员工性别统计数据
     * @return
     */
    @MapKey("gender")
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 根据用户名和密码登录
     * @param emp
     * @return
     */
    Emp loginByUsernameAndPassword(Emp emp);
}