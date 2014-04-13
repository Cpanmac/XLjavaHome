package com.xl.����;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xl.entity.Person;

/*
 * �ҳ��ֵ����⣺��Person�й��췽����Ĭ�ϵ�ʱ��,getConstructorû�л���乹�췽��
 */
public class ��ȡClass�еĹ��캯�� {
	private String s;

	@Before
	public void before() {
		// ���ص���
		s = "reflect.Person";
	}

	// ���乹�캯��(�ղ�������public Person()
	@Test
	public void createNewObject() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		String name = "reflect.Person";
		Class clazz = Class.forName(name);
		// ������ֻ��һ����ȡ�ղ����ķ���newInstance
		Object obj = clazz.newInstance(); // �����˿ղ����Ĺ��캯����
		Person p = (Person) obj;
		System.out.println(p.name);
		// �쳣��
		// 1.���û�пղεĹ��캯���ᱨһ��java.lang.InstantiationException��ʼ���쳣
		// 2.������캯����private����java.lang.IllegalAccessException��Ч�����쳣
	}

	// �������û�пղεĹ��캯��,�õ����й��õĹ��캯��
	@Test
	public void createNewObject_2() throws Exception {
		Class clazz = Class.forName("reflect.Person");
		// 1.�õ���������й��еĹ��캯��getConstructors()
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("xxx");
		System.out.println(p.name);
	}

	// ˽�еĹ��캯��
	@Test
	public void test() throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class clazz = Class.forName(s);
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);
		Person p = (Person) c.newInstance(new ArrayList());
		System.out.println(p.name);
	}
}
