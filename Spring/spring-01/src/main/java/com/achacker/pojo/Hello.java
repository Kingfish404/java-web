package com.achacker.pojo;

public class Hello {

    private String str;

    public void sayHello() {
        System.out.println("Hello");
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
