package com.xl.����;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class ����Demo implements parent {
	@Test
	public void �õ�����() throws InstantiationException, IllegalAccessException {
		// �õ����͵���ʵ��Ϣ
		Class clazz = this.getClass(); // �õ���ǰnew�Ķ���
		System.out.println(clazz.getName());
		Type[] parent = clazz.getGenericInterfaces();
		System.out.println(parent[0]);
		Class inter = clazz.getInterfaces()[0];
		System.out.println(inter.getName());
		
		// ParameterizedType pt = (ParameterizedType)
		// clazz.getGenericSuperclass(); // �õ����͵ĸ���
		// System.out.println(pt);
		// clazz = (Class) pt.getActualTypeArguments()[0];
		// System.out.println(clazz);
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub

	}
}

interface parent {
	void say();
}