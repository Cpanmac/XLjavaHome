package com.xl.���ģʽ.����ģʽ;

public class Person {
    public static final Person person = new Person();
    private String name;

    //���캯��˽�л�
    private Person() {
    }

    //�ṩһ��ȫ�ֵľ�̬����
    public static Person getPerson() {
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
