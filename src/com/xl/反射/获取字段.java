package com.xl.����;

import java.lang.reflect.Field;

import org.junit.Test;

import com.xl.entity.Person;

public class ��ȡ�ֶ� {
	private String s = "reflect.Person";

	/*
	 * ��ȡ�����ֶ�
	 */
	@Test
	public void test1() throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, InstantiationException, IllegalAccessException {
		Person p = new Person();
		Class clazz = Class.forName(s);
		Field f = clazz.getField("name"); // ��������
		String name = (String) f.get(p);
		System.out.println(name);

		/*
		 * �����֪���ֶ�����
		 */
		Class type = f.getType();
		System.out.println(type); // class java.lang.String
		Object value = f.get(p);
		Object obj = f.get(p);
		if (type.equals(String.class)) {
			String svalue = (String) value;
			System.out.println(svalue);
		}

		/*
		 * �����ֶε�ֵ
		 */
		f.set(p, "xxx");
		System.out.println(p.name);
	}
	/*
	 * ��ȡ˽�е��ֶ�
	 */
	@Test
	public void test2() throws Exception{
		Person p=new Person();
		Class clazz=Class.forName(s);
		Field f=clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	/*
	 * ��ȡ��̬���ֶ�:������һ��������ʡ�Զ���
	 */
}
