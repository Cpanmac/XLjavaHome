package com.xl.Regex;

import org.junit.Test;

/*
 ������ʽ������һ������ı��ʽ��
 ���ã�ר�����ڲ����ַ���

 */

/*
 ���󣺶�QQ�������У��
 Ҫ��5~15   0���ܿ�ͷ��ֻ��������
 regex������ʽ
 */
public class ������ʽ {

	/*
	 * 
	 * ƥ��
	 * 
	 * �ֻ��Ŷ�ֻ��13XXX 15XXX 18xxxx
	 */
	@Test
	public void checkTel() {
		String tel = "1312345";
		String telReg = "1[358]\\d{1,9}"; // ����
		System.out.println(tel.matches(telReg));
	}

	// ����QQ����
	@Test
	public void checkQQ() {
		String qq = "1654";
		String regex = "[1-9][0-9]{4,14}"; // ��һλ��1��9���ڶ�λ��0��9��λ����4��14λ

		boolean flag = qq.matches(regex);
		System.out.println(flag);
	}
}
