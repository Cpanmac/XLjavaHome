package com.xl.����;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xl.util.FileTool;

public class ListDemo {
	List<String> list = new ArrayList<String>();

	/**
	 * ������ת��Ϊ����
	 */
	@Test
	public void test() {
		list.add("����");
		list.add("����");
		String[] str = new String[list.size()];
		list.toArray(str);
		for (String s : str) {
			System.out.println(s);
		}
	}
}
