package cn.ayeez.mapper;

import cn.ayeez.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动的将该实现类对象存入IOC容器 -bean
public interface UserMapper {

//    @Select("select id, username, password, name, age from user")
    public List<User> findAll();

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);

    @Insert("insert into user(username,password,name,age) values(#{username},#{password},#{name},#{age})")
    public void insertUser(User user);

    @Update("update user set username= #{username},password= #{password},name = #{name} where id = #{id}")
    public void updateUser(User user);

    @Select("select * from user where username= #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
