package com.xl.����;

import java.lang.reflect.Method;

import org.junit.Test;

public class ����set��get���� {
	@Test
	public void main() {
		Class<?> demo = null;
		Object obj = null;
		try {
			demo = Class.forName("reflect.Person");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			obj = demo.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setter(obj, "name", "��", String.class);
		getter(obj, "name");
	}

	/**
	 * @param obj
	 *            �����Ķ���
	 * @param att
	 *            ����������
	 * */
	public void getter(Object obj, String att) {
		try {
			att = toUp(att);
			Method method = obj.getClass().getMethod("get" + att);
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param obj
	 *            �����Ķ���
	 * @param att
	 *            ����������
	 * @param value
	 *            ���õ�ֵ
	 * @param type
	 *            ����������
	 * */
	public void setter(Object obj, String att, Object value, Class<?> type) {
		try {
			att = toUp(att);
			Method method = obj.getClass().getMethod("set" + att, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����һ����ĸ�ĳɴ�д
	 * 
	 * @param content
	 */
	private String toUp(String content) {
		StringBuffer sb = new StringBuffer(content);
		String s =sb.substring(0, 1);
		s = s.toUpperCase();
		sb.replace(0, 1, s);
		return sb.toString();
	}
}
