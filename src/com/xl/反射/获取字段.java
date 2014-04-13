package com.xl.反射;

import java.lang.reflect.Field;

import org.junit.Test;

import com.xl.entity.Person;

public class 获取字段 {
	private String s = "reflect.Person";

	/*
	 * 获取公有字段
	 */
	@Test
	public void test1() throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, InstantiationException, IllegalAccessException {
		Person p = new Person();
		Class clazz = Class.forName(s);
		Field f = clazz.getField("name"); // 传属性名
		String name = (String) f.get(p);
		System.out.println(name);

		/*
		 * 如果不知道字段类型
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
		 * 设置字段的值
		 */
		f.set(p, "xxx");
		System.out.println(p.name);
	}
	/*
	 * 获取私有的字段
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
	 * 获取静态的字段:和上面一样，不能省略对象。
	 */
}
