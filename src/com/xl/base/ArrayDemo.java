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
	 * @param pData ����
	 * @param left ����Ŀ�ʼλ�ô�0��ʼ
	 * @param right ����Ľ���λ��
	 */
	public static void QuickSort(int[] pData, int left, int right) {
		int i, j;
		int middle, temp;
		i = left;
		j = right;
		middle = pData[left];
		while (true) {
			while ((++i) < right - 1 && pData[i] < middle)
				; // ����ߵڶ���Ԫ�ؿ�ʼ���ҳ���middle���Ԫ��
			while ((--j) > left && pData[j] > middle)
				; // ���ұߵ�һ��Ԫ�ؿ�ʼ���ҳ���middleС��Ԫ��
			if (i >= j) // �� i С�� j ��ʱ�򣬽�������Ԫ�ص�λ��
				break;
			temp = pData[i];
			pData[i] = pData[j];
			pData[j] = temp;
		}
		// �����������˼��pData[left] �� pData[j] ���н������������γ�����pData[j]Ϊ���ĵ����飬�±�С��
		// j��Ԫ�ر�pData[j]С���±����j��Ԫ�ر�pData[j]��
		pData[left] = pData[j];
		pData[j] = middle;
		// ��pData[j]��ߵ�Ԫ�أ����õݹ�
		if (left < j)
			QuickSort(pData, left, j);
		// ��pData[j]�ұߵ�Ԫ�أ����õݹ�
		if (right > i)
			QuickSort(pData, i, right);
	}
}
