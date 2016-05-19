package com.xl.����;

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

    public boolean equals(Object obj) // ��Person�и�д��������equals����
    {
        if (!(obj instanceof Person)) // ��obj���ж��Ƿ���Person��
            return false;
        Person p = (Person) obj;
        System.out.println(this.name + "..." + p.getAge());
        return this.name.equals(p.getName()) && (this.age == p.getAge()); // �������equals��String������equals
    }
}
