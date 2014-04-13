package com.xl.泛型;

import java.util.Arrays;

import org.junit.Test;

public class 实现指定位置上的数据元素交换 {

	// 在前面要先定义泛型<T>
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
