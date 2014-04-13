package com.xl.反射;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	// 唯一序列化标识
	public static final long serialVersionUID = 42L; // 值自己取名

	public static void aa1(int num) {
		System.out.println(num);
	}

	// transient 该字段无法序列化，所以传输对象的时候不会传过去
	transient String pas;
	public String name = "这是name";
	// private int password=123;
	private String password;

	private String birthday;

	private static int age = 13;

	public static void main(String[] args) {
		System.out.println("这是main方法！");
	}

	public Person() {
		System.out.println("空参数的构造函数");
	}

	private Person(List list) {
		System.out.println("haha");
	}

	public Person(String name) {
		this.name = name;
		System.out.println(name);
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void aa1() {
		System.out.println("aa1");
	}

	public void aa1(InputStream in) {
		System.out.println(in);
	}

	public void aa1(String name, int password) {
		System.out.println(name + ":" + password);
	}

	private void eat() {
		System.out.println("私有的吃");
	}

	public int getAge() {
		return age;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void paramMethod(String name, int age) {
		System.out.println(name + age);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void show() {
		System.out.println("私有的");
	}
}
