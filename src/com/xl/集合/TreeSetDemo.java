package com.xl.����;

/*
 * ��TreeSet�����д洢�Զ������ѧ��. �밴��ѧ���������������
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> ts=null;
         ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getName().equals(o2.getName())) {
                    return 0;
                }
                return 1;
            }
        });
        ts.add(new Student("lisi02", 22));
        ts.add(new Student("lisi02", 22));
        ts.add(new Student("lisi02", 22));
        ts.add(new Student("lisi09", 19));
        ts.add(new Student("lisi01", 40));
        Student s = new Student("lisi01", 1);

        ts.add(new Student("lisi09", 19));

        Iterator<Student> it = ts.iterator();
        while (it.hasNext()) {
            Student stu = (Student) it.next(); // ������ӡ����Ļ�
            System.out.println(stu.getName() + "..." + stu.getAge());
        }
    }
}

class Student // ǿ����ѧ���߱��Ƚ��ԡ�
{
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
