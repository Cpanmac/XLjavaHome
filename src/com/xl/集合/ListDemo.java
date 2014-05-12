package com.xl.集合;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xl.util.FileTool;

public class ListDemo {
	List<String> list = new ArrayList<String>();

	/**
	 * 将集合转换为数组
	 */
	@Test
	public void test() {
		list.add("张三");
		list.add("李四");
		String[] str = new String[list.size()];
		list.toArray(str);
		for (String s : str) {
			System.out.println(s);
		}
	}
}
