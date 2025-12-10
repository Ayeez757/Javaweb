package cn.ayeez;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcTest {

    /**
     * JDBC入门程序
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/web01";
        String username="root";
        String password="1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("update user set age = 23 where id =1");
        System.out.println(i);
        System.out.println(i);
        System.out.println(i);
        System.out.println(i);
        statement.close();
        connection.close();


    }





}
