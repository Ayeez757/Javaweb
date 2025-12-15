package cn.ayeez;

import cn.ayeez.mapper.UserMapper;
import cn.ayeez.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//springboot单元测试注解，当前测试类中的测试方法运行时，会启动springboot应用 -IOC容器
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDeleteById(){
        userMapper.deleteById(5);

    }

    @Test
    public void testInsert(){
        User user = new User(null, "ayeez", "123456", "ayeez", 18);
        userMapper.insertUser( user);
    } 

    @Test
    public void testUpdate(){
        User user = new User(6, "ayeez", "1234567", "ayeez", 18);
        userMapper.updateUser(user);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("ayeez", "1234567");
        System.out.println(user);
    }

}
