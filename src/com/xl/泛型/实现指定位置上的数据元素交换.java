package com.xl.����;

import java.util.Arrays;

import org.junit.Test;

public class ʵ��ָ��λ���ϵ�����Ԫ�ؽ��� {

	// ��ǰ��Ҫ�ȶ��巺��<T>
	public <T> void swap(T arr[], int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	@Test
	public void test() {
		String[] arr = new String[] { "1", "2", "3" };
		swap(arr, 0, 2);
		System.out.println(Arrays.toString(arr));
	}
}
