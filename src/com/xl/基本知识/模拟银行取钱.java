package com.xl.基本知识;

import java.util.Scanner;

/**
 * 3.模拟银行取钱 首先通过用户名和密码的验证，然后输入取钱的金额， 金钱要小于1000并且是100的倍数，如果条件符合就是跳出循环，显示取出金额
 * 如果不是，则提示重新输入取钱的金额。 如果密码错误，就提示信息输入错误！
 */
public class 模拟银行取钱 {
	public static void main(String[] args) {
		String userName = "fengshuai";
		int userPassWord = 123456;
		String name;
		int passWord;
		int money;
		boolean bl = true;
		Scanner sr = new Scanner(System.in);
		do {
			System.out.print("请输入用户名：");
			name = sr.next();
			System.out.print("请输入密码：");
			passWord = sr.nextInt();
			if ((!name.equals(userName)) || (passWord != userPassWord)) {
				System.out.println("您的输入有误，请重新输入！");
			}
		} // 怎么将密码错误的提示语加入循环
		while ((!name.equals(userName)) || (passWord != userPassWord));
		do {
			System.out.println("请输入您要取的金额：");
			money = sr.nextInt();
			for (; money < 1000 && money % 100 == 0;) {
				break;
			}
			System.out.println("您的取款金额为：" + money);
			if (money >= 1000 || money % 100 != 0) {
				System.out.println("您输入的取款金额有误，请重新输入：");// 这里的循环怎么搞
			}
		} while ((money >= 1000 || money % 100 != 0));
	}
}
