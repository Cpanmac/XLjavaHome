package com.xl.����;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.xl.entity.Person;

public class ��ȡ���� {
	private String className = null;
	Person p = new Person();
	
	@Before
	public void before() {
		className = "reflect.Person";
	}
	
	/*
	 * ��ȡָ��Class�еĹ��з�����
	 */
	@Test
	public void getMethodDemo() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class<?> clazz = Class.forName(className);
		Method[] methods = clazz.getMethods(); // ��ȡ�Ķ��ǹ��е�
		// ��һ�������Ƿ��������֣�����Ĳ����Ƿ����Ĳ�������
		// Method method = clazz.getMethod("aa1", String.class, int.class);
		// �����������
		// method.invoke(p, "sa", 36);
		for (Method amethods : methods) {
			// ��ӡ���õķ���ȫ��
			System.out.println(amethods.getName());
		}
		// ֻ��ȡ˽�еķ���
		methods = clazz.getDeclaredMethods();
		for (Method bmethods : methods) {
			System.out.println(bmethods);
		}
	}
	
	// �޲εķ���
	@Test
	public void getMethodDemo_2() throws Exception {
		Class<?> clazz = Class.forName("����.Person");
		Method method = clazz.getMethod("show", null); // ��ȡ�ղ�����һ�㷽����
		// Object obj=clazz.newInstance(); //����Person����
		// method.invoke(obj,null); //ֱ��������show�����������˽�е����в���
		Constructor constructor = clazz.getConstructor(String.class, int.class);
		Object obj = constructor.newInstance("С��", 30);
	}
	
	// ��̬����
	@Test
	public void getMethodDemo_3() throws Exception {
		Class<?> clazz = Class.forName(className);
		Method method = clazz.getMethod("aa1", int.class);// ������+�����б�
		// ��Ϊ�Ǿ�̬�����Բ���Ҫ����
		method.invoke(null, 23); // ����
	}
	
	// main����,�׳�һ����������쳣
	@Test
	public void test1() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		Method method = clazz.getMethod("main", String[].class);
		// 1.����һ��
		method.invoke(null, new Object[] { new String[] { "aa", "bb" } }); // jdk1.4û��String[],
		                                                                   // ���������������������̲����ݵ���,���Ա����Object
		// 2.���������������¾��У��ⲻ������
		method.invoke(null, (Object) new String[] { "sasa", "sqd" });
	}
}
