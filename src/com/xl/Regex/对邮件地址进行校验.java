package com.xl.Regex;

import org.junit.Test;

public class ���ʼ���ַ����У��

{
	@Test
	public void checkMail() {
		String mail = "abc12@sina.com.cn.cn.cn";
		// ��Ծ�ȷ��ƥ��
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}"; // 6��12λ���û���
		// �����ͳ��ƥ��
		reg = "\\w+@\\w+(\\.\\w+)+";
		System.out.println(mail.matches(reg));
		// �Ƚϵ��ƥ��
//		 while(mail.indexOf("@")!=-1&&mail.indexOf("."))
	}
}
