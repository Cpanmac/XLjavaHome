package com.xl.����֪ʶ;
/**
 * 3.��1~50�У���7�����ĺ�
 * */
public class ��1��50��7�ı����ĺ� {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		while (a <= 50) {
			if (a % 7 == 0) {
				b = b + a;
			}
			a++;
		}
		System.out.println("��7�����ĺ���:\t" + b);

	}

}
