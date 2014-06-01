package com.xl.base;

import java.util.Arrays;

import org.junit.Test;

public class ArrayDemo {
	private int[] intArray = new int[] { 3, 56, 1, 4, 76721, 343, 1 };
	
	@Test
	public void testSort() {
		QuickSort(intArray, 0, 3);
		System.out.println(Arrays.toString(intArray));
	}
	
	/**
	 * @param pData 数组
	 * @param left 排序的开始位置从0开始
	 * @param right 排序的结束位置
	 */
	public static void QuickSort(int[] pData, int left, int right) {
		int i, j;
		int middle, temp;
		i = left;
		j = right;
		middle = pData[left];
		while (true) {
			while ((++i) < right - 1 && pData[i] < middle)
				; // 从左边第二个元素开始，找出比middle大的元素
			while ((--j) > left && pData[j] > middle)
				; // 从右边第一个元素开始，找出比middle小的元素
			if (i >= j) // 当 i 小于 j 的时候，交换两个元素的位置
				break;
			temp = pData[i];
			pData[i] = pData[j];
			pData[j] = temp;
		}
		// 下面两句的意思：pData[left] 和 pData[j] 进行交换，这样就形成了以pData[j]为中心的数组，下标小于
		// j的元素比pData[j]小，下标大于j的元素比pData[j]大。
		pData[left] = pData[j];
		pData[j] = middle;
		// 对pData[j]左边的元素，调用递归
		if (left < j)
			QuickSort(pData, left, j);
		// 对pData[j]右边的元素，调用递归
		if (right > i)
			QuickSort(pData, i, right);
	}
}
