package com.xl.����;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class ArraysDemo {
	public static void main(String[] args) {
		// int[] arr = {2,4,5};
		// System.out.println(Arrays.toString(arr));
		Integer[] arr = { 1123, 12, 11, 13, 1 };
		// List<int[]> list = Arrays.asList(arr); // ������ǵ�ַ дint�����
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 1;
			}
		});
		System.out.println(Arrays.toString(arr));
		// System.out.println(list);
		// Integer[] nums = { 2, 4, 5, 3, 0, 9 }; // �Զ�װ��
		// List<Integer> li = Arrays.asList(nums);
		// System.out.println(li);
		// Collections.reverse(li);
		// System.out.println(li);
	}

	/**
	 * �������鳤��10%+10
	 * 
	 * @param a
	 *            ����
	 * @return ���������
	 */
	@Test
	public Object ArrayGrow(Object a) {
		Class class1 = a.getClass();
		if (!class1.isArray())
			return null;
		Class componentType = class1.getComponentType();
		// int length = Arrays.getLength(a);
		// int newLength = length * 11 / 10 + 10;
		// Object newObj = Array.newInstance(componentType, newLength);
		// System.arraycopy(a, 0, newObj, 0, length);
		// return newObj;
		return null;
	}

	@Test
	public void ��������() {
		String[] a = new String[] { "referf", "dswefwf", "regre" };
		p(a);
		String[] b;
		a = Arrays.copyOf(a, a.length + 1);
		p(a);
	}

	private void p(Object[] obj) {
		System.out.println(obj.getClass().getName());
		int i = 0;
		for (Object o : obj) {
			System.out.println(i);
			i++;
			System.out.println(o.toString());
		}
	}
}
