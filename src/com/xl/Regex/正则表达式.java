package com.xl.Regex;

import org.junit.Test;

/*
 正则表达式：符合一定规则的表达式：
 作用：专门用于操作字符串

 */

/*
 需求：对QQ号码进行校验
 要求：5~15   0不能开头，只能是数字
 regex正则表达式
 */
public class 正则表达式 {

	/*
	 * 
	 * 匹配
	 * 
	 * 手机号段只有13XXX 15XXX 18xxxx
	 */
	@Test
	public void checkTel() {
		String tel = "1312345";
		String telReg = "1[358]\\d{1,9}"; // 规则
		System.out.println(tel.matches(telReg));
	}

	// 接受QQ号码
	@Test
	public void checkQQ() {
		String qq = "1654";
		String regex = "[1-9][0-9]{4,14}"; // 第一位是1到9，第二位是0到9，位数是4到14位

		boolean flag = qq.matches(regex);
		System.out.println(flag);
	}
}
