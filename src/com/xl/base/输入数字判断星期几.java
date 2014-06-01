package com.xl.base;
/** 1.输入一个数字，1-7,判断输入的数字是星期中的那天，比如1对应的就是星期一。。
 输入0来结束循环
 */

import java.util.Scanner;

public class 输入数字判断星期几 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String name = null;
		int no;

		while (true) {
			System.out.println("请输入一个数字(1-7)，如果输入0则结束：");
			no = input.nextInt();
			if (no < 0 || no > 7) {
				System.out.println("输入错误数字 ！请重新输入！！");
				continue;
			}
			if (no == 0) {
				System.out.println("结束 谢谢使用");
				break;
			}
			switch (no) {
			case 1:
				name = "星期一";
				break;
			case 2:
				name = "星期二";
				break;
			case 3:
				name = "星期三";
				break;
			case 4:
				name = "星期四";
				break;
			case 5:
				name = "星期五";
				break;
			case 6:
				name = "星期六";

				break;
			case 7:
				name = "星期日";
				break;

			}
			if (no == 0) {
				break;
			}

			System.out.println(name);

		}

	}

}