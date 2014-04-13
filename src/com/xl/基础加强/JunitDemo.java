package com.xl.������ǿ;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitDemo {

	// ʹ��Junit���Լ�@Test�Ϳ��� Ҫֱ�Ӳ������еķ����͵��������Ȼ��run as
	private Person p;

	// Before���ڲ���֮ǰ�ض����У����Կ��԰ѳ�ʼ��Person����Before
	// �ص㣺ÿ�����Է���������
	@Before
	public void before() {
		System.out.println("before");
		p = new Person();
	}

	@Test
	public void testRun() {
		// Person p = new Person();
		p.run();
		// ����.����ܶ෽��
		// һ������ֵ��һ������ֵ
		// Assert.assertEquals("2",p.run());
		// �������ص�������1��1. ʵ�ʵķ��ص�������1��2
		Assert.assertArrayEquals(new int[] { 1, 1 }, new int[] { 1, 2});
	}

	@Test
	public void testEat() {
		// Person p = new Person();
		p.eat();
	}

	// After���������ر���Դ
	@After
	public void after() {
		// System.out.println("after");
		p = null;
	}

	// ���Ҫ��Before�����ȼ��أ�����ص�ʱ������
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void aflterClass() {
		System.out.println("AfterClass");
	}

}
