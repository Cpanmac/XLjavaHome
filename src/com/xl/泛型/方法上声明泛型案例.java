package com.xl.泛型;

import org.junit.Test;

public class 方法上声明泛型案例 {
	@Test
	public void test() {
		// int[] arr={3,1,5,7};
		String[] arr = { "saasd", "asd" };
		reverse(arr);
		for (String s : arr) {
			System.out.println(s);
		}
	}

	// 接受任意数组并颠倒所有元素
	public <T> void reverse(T arr[]) {
		int start = 0;
		int end = arr.length - 1;
		while (true) {
			if (start >= end) {
				break;
			}
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
