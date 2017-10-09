package com.xl.entity;

public class Student {
    private String sex;
    private String name;
    private int age;
    private String phone;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String sex, String name, int age, String phone) {
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
