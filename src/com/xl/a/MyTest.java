package com.xl.a;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTest {
	// 测试能不能对自己转型
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
