package com.xl.entity;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    // Ψһ���л���ʶ
    public static final long serialVersionUID = 42L; // ֵ�Լ�ȡ��
    private static int age = 13;
    public String name = "����name";
    // transient ���ֶ��޷����л������Դ�������ʱ�򲻻ᴫ��ȥ
    transient String pas;
    // private int password=123;
    private String password;
    private String birthday;

    public Person() {
        System.out.println("�ղ����Ĺ��캯��");
    }

    public Person(String name) {
        this.name = name;
        System.out.println(name);
    }

    private Person(List list) {
        System.out.println("haha");
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person p = new Person("���ǵ���");
    }

    public static void aa1(int num) {
        System.out.println(num);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void aa1() {
        System.out.println("aa1");
    }

    private void eat() {
        System.out.println("˽�еĳ�");
    }

    public void aa1(String name, int password) {
        System.out.println(name + ":" + password);
    }

    public void aa1(InputStream in) {
        System.out.println(in);
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

    public void show() {
        System.out.println("˽�е�");
    }

    public void paramMethod(String name, int age) {
        System.out.println(name + age);
    }

    public void run() {
        System.out.println("Person.run()");
    }
}
