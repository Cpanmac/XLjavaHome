package com.xl.��ʡ;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import com.xl.entity.Person;

/*
 * ʹ��beanUtils����bean�����ԣ�������jar����commons-beanutils-1.8.0.jar������Ҫ֧�ּ� commons-logging.jar ��ֵ����������ֱ������
 */
public class beanutils��� {
	@Test
	public void ��ֵ() throws IllegalAccessException,
			InvocationTargetException {
		Person p = new Person();
		// ��������
		BeanUtils.setProperty(p, "name", "��ֵ������1");
		System.out.println(p.getName());
	}

	/*
	 * �ô���ֱ�ӽ�����123����ֵ����int age��֧��8�ֻ����������͡���֧������
	 */
	@Test
	public void Test2() throws IllegalAccessException,
			InvocationTargetException {
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birthday = "1990-02-28";
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		System.out.println(p.getName() + ".." + p.getPassword() + ".."
				+ p.getAge() + ".." + p.getBirthday());
	}

	/*
	 * 
	 */
	@Test
	public void test3() {
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birhday = "1980-09-09";
		Person p = new Person();
		// Ϊ�������ڵ�bean��birhday�����ϣ����Ǹ�beanUtilsע��һ������ת����
		// �ӿڲ���new��ԭ����������û��ʵ�ֵķ�����ֻҪ�ѷ���ʵ���˾���new��
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				if (value == null) {
					return null;
				}
				if (!(value instanceof String)) {
					// throw new CoversionException("ֻ֧��String����ת������");
				}
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parseObject(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.setProperty(p, "name", name);
			BeanUtils.setProperty(p, "password", password);
			BeanUtils.setProperty(p, "age", age);
			BeanUtils.setProperty(p, "birthday", birhday);
			System.out.println(p.getName() + ".." + p.getPassword() + ".."
					+ p.getAge());
			System.out.println(p.getBirthday());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ����Map����
	 */
	@Test
	public void test5() {
		Map map = new HashMap();
		map.put("name", "asda");
		map.put("password", "123");
		map.put("age", "23");
		map.put("birthday", "1980-09-09");
		// ע��ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person bean = new Person();
		try {
			BeanUtils.populate(bean, map);
			System.out.println(bean.getName() + bean.getPassword()
					+ bean.getBirthday());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
