package com.achacker.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import javax.annotation.Resource;

public class People {

    private String name;
    private int age;

    // 自动装配，通过类型，名字
    @Autowired
    private Hello hello;

    // 自动装配，通过名字，类型
    @Resource
    private Hello hello2;

    People(@Nullable int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void setHello2(Hello hello2) {
        this.hello2 = hello2;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hello=" + hello +
                ", hello2=" + hello2 +
                '}';
    }
}
