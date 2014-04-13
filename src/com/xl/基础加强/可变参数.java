package com.xl.基础加强;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class 可变参数 {
	@Test
	public void testSum() {
		sum(1, 2, 3, 4, 5, 6, 7, 8);
		// 可变参数可以看成数组
		int[] arr = { 1, 3, 4, 1 };
		sum(arr);
	}

	public void sum(int... num) {
		int sum = 0;
		for (int i : num) {
			sum += i;
		}
		System.out.println(sum);
	}

	// 可变参数需要注意的问题:
	// 1.可变参数要放在后面，否则会报错
	public void aa(int x, int... num) {
	}
	@Test
	public void bb(){
//		Arrays把这个放进List
		List list=Arrays.asList("1","2","3");
		System.out.println(list);
		int nums[]={1,2,3,5};
//		这个是打印对象
		list=Arrays.asList(nums);
		System.out.println(list);
		//转成对象类型的时候就可以了
		Integer nums2[]={1,2,3,5};
		list=Arrays.asList(nums2);
		System.out.println(list);
	}
}
