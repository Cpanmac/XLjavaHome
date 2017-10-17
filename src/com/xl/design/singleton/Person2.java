package com.xl.design.singleton;

public class Person2 {
    private static Person2 person;
    private String name;

    //���캯��˽�л�
    private Person2() {
    }

    //�ṩһ��ȫ�ֵľ�̬����
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
