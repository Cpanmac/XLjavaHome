package com.xl.基本知识;
import java.util.Scanner;

/**
 * 4.升级上一次求最大值和最小值（利用数组）
 * 
 */
public class 求最大值和最小值{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("你想输入几个数字？");
		int i = input.nextInt();// 想输入的数字
		int num[] = new int[i];// 数组的长度
		System.out.print("输入数字：");
		num[0] = input.nextInt();
		int max = num[0];
		int min = num[0];
		for (int x = 1; x < i; x++) {
			System.out.print("输入数字：");
			num[x] = input.nextInt();
		}
		for (int j = 1; j < num.length; j++) {
			if (max < num[j]) {
				max = num[j];
			}

			if (min > num[j]) {
				min = num[j];
			}

		}
		System.out.println("最大值为：" + max + "  " + "最小值为：" + min);
	}
}
