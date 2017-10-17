package com.xl.design.singleton;

public class Person2 {
    private static Person2 person;
    private String name;

    //构造函数私有化
    private Person2() {
    }

    //提供一个全局的静态方法
    public static Person2 getPerson() {
        if (person == null) {
            person = new Person2();
        }
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
