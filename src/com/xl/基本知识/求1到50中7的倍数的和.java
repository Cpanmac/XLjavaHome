package com.xl.基本知识;
/**
 * 3.求1~50中，是7倍数的和
 * */
public class 求1到50中7的倍数的和 {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		while (a <= 50) {
			if (a % 7 == 0) {
				b = b + a;
			}
			a++;
		}
		System.out.println("是7倍数的和是:\t" + b);

	}

}
