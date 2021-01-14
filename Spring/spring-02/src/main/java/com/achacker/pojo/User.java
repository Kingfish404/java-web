package com.achacker.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// @Component 组件
// 等价与 <bean id="user" class="com.achacker.pojo.User"/>
@Component
public class User {
    public String name = "User";

    @Value("11")
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
