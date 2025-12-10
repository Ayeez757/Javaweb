package cn.ayeez.springbootweb01.javabean;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime registerTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
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

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public User(Integer id, String userName, String password, String name, Integer age, LocalDateTime registerTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.registerTime = registerTime;
    }

    public User() {
    }
}
