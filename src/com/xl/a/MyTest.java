package com.xl.a;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTest {
	// �����ܲ��ܶ��Լ�ת��
	@Test
	public void test1() {
		List list = new ArrayList();
		System.out.println(list.getClass().getSimpleName());
		list = (List) list;
		System.out.println(list.getClass().getSimpleName());
		list=(ArrayList)list;
		System.out.println(list.getClass().getSimpleName());
	}
}
