package com.xl.集合;

/*
 * 往TreeSet集合中存储自定义对象学生. 想按照学生的年龄进行排序
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
			Student stu = (Student) it.next(); // 如果想打印对象的话
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

class Student implements Comparable // 强制让学生具备比较性。
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
