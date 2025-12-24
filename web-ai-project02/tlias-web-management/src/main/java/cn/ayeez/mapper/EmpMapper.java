package cn.ayeez.mapper;

import cn.ayeez.pojo.Emp;
import cn.ayeez.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;


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

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);
}