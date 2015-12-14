package com.xl.����;

/*
 * ��TreeSet�����д洢�Զ������ѧ��. �밴��ѧ���������������
 */
import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("lisi02", 22));
		ts.add(new Student("lisi02", 22));
		ts.add(new Student("lisi09", 19));
		ts.add(new Student("lisi01", 40));
		Iterator<Student> it = ts.iterator();
		while (it.hasNext()) {
			Student stu = (Student) it.next(); // ������ӡ����Ļ�
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

class Student implements Comparable // ǿ����ѧ���߱��Ƚ��ԡ�
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
	
	public int compareTo(Object obj) {
		return -1;
	}
}
