package com.xl.����;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	// Ψһ���л���ʶ
	public static final long serialVersionUID = 42L; // ֵ�Լ�ȡ��

	public static void aa1(int num) {
		System.out.println(num);
	}

	// transient ���ֶ��޷����л������Դ�������ʱ�򲻻ᴫ��ȥ
	transient String pas;
	public String name = "����name";
	// private int password=123;
	private String password;

	private String birthday;

	private static int age = 13;

	public static void main(String[] args) {
		System.out.println("����main������");
	}

	public Person() {
		System.out.println("�ղ����Ĺ��캯��");
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
		System.out.println("˽�еĳ�");
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
		System.out.println("˽�е�");
	}
}
