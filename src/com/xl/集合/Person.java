package com.xl.集合;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object obj) // 在Person中覆写掉父类中equals方法
    {
        if (!(obj instanceof Person)) // 传obj先判断是否是Person类
            return false;
        Person p = (Person) obj;
        System.out.println(this.name + "..." + p.getAge());
        return this.name.equals(p.getName()) && (this.age == p.getAge()); // 这里面的equals是String方法的equals
    }
}
