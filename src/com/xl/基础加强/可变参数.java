package com.xl.������ǿ;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class �ɱ���� {
	@Test
	public void testSum() {
		sum(1, 2, 3, 4, 5, 6, 7, 8);
		// �ɱ�������Կ�������
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

	// �ɱ������Ҫע�������:
	// 1.�ɱ����Ҫ���ں��棬����ᱨ��
	public void aa(int x, int... num) {
	}
	@Test
	public void bb(){
//		Arrays������Ž�List
		List list=Arrays.asList("1","2","3");
		System.out.println(list);
		int nums[]={1,2,3,5};
//		����Ǵ�ӡ����
		list=Arrays.asList(nums);
		System.out.println(list);
		//ת�ɶ������͵�ʱ��Ϳ�����
		Integer nums2[]={1,2,3,5};
		list=Arrays.asList(nums2);
		System.out.println(list);
	}
}
