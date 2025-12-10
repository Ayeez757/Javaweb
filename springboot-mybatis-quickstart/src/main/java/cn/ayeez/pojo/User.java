package cn.ayeez.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String name, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
    }
}
