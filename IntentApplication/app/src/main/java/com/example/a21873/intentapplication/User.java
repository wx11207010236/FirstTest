package com.example.a21873.intentapplication;

import java.io.Serializable;

/**
 * Created by 21873 on 2020/4/10.
 */

public class User implements Serializable{//对象序列化

    private String name;
    private  int id;
    private String pwd;
    private  int age;



    public User() {
    }

    public User(String name, int id, String pwd, int age) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }
}
