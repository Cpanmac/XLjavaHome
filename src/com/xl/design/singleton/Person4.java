package com.xl.design.singleton;

public class Person4 {
    private static Person4 person;
    private String name;

    //构造函数私有化
    private Person4() {
    }

    //提供一个全局的静态方法
    public static Person4 getPerson() {
        if (person == null) {
            synchronized (Person4.class) {
                if (person == null) {
                    person = new Person4();
                }
            }
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
