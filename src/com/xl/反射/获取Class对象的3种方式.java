package com.xl.����;

import org.junit.Test;

import com.xl.entity.Person;

public class ��ȡClass�����3�ַ�ʽ {

	// 1.��ȡ�ֽ������ķ�ʽ:
	@Test
	public void getClassObject_1() throws ClassNotFoundException {
		Person p = new Person();
	}

	// ��ʽ����
	// 2.�κ��������Ͷ��߱�һ����̬������.class����ȡ��Ӧ��Class����
	// �ص㣺��Լ򵥣����ǻ���Ҫ��ȷ�õ����еľ�̬��Ա�����ǲ�����չ
	@Test
	public void getClassObject_2() {
		Class clazz = Person.class;
		Class clazz1 = Person.class;
		Class clazz2 = new Person().getClass();
		System.out.println(clazz);
		System.out.println(clazz2);
		System.out.println(clazz == clazz1);
	}

	// ��ʽ����
	// ֻҪͨ����������ַ������ƾͿ��Ի�ȡ���࣬��Ϊ��չ��
	// ������Class���еķ�����ɡ� �÷�������forName
	@Test
	public void getClassObject_3() throws ClassNotFoundException {
		String className = "java.lang.Class"; // ���������
		String className1 = "reflect.��ȡClass�����3�ַ�ʽ"; // �����Ŷ�
		String className2 = "Person"; // �����Ǵ����
		Class clazz = Class.forName(className);
		// Class clazz2=Class.forName(className2);
		System.out.println(clazz);
		// System.out.println(clazz2);
	}

}
