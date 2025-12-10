package cn.ayeez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMybatisQuickstartApplication {

    /**
     * 1.SpringBoot+Mybatis
     * 创建springboot工程，映入mybatis相关依赖
     * 准备数据库表、实体类
     * application.properties中配置数据库连接信息
     * 定义Mapper接口（@mapper），编写sql
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisQuickstartApplication.class, args);
    }

}
