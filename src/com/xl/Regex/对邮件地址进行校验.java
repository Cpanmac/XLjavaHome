package com.xl.Regex;

import org.junit.Test;

public class 对邮件地址进行校验

{
	@Test
	public void checkMail() {
		String mail = "abc12@sina.com.cn.cn.cn";
		// 相对精确的匹配
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}"; // 6到12位的用户名
		// 相对笼统的匹配
		reg = "\\w+@\\w+(\\.\\w+)+";
		System.out.println(mail.matches(reg));
		// 比较叼的匹配
//		 while(mail.indexOf("@")!=-1&&mail.indexOf("."))
	}
}
