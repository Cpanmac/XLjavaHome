package com.xl.design.singleton;

public class Person3 {
    private static Person3 person;
    private String name;

    //���캯��˽�л�
    private Person3() {
    }

    //�ṩһ��ȫ�ֵľ�̬������ʹ��ͬ������
    public static synchronized Person3 getPerson() {
        if (person == null) {
            person = new Person3();
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
