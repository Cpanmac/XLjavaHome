package com.xl.Regex;

/*
 ���ַ����еķ��Ϲ�����ִ�ȡ����
 �������裺
 1.��������ʽ��װ�ɶ���
 2.����������Ҫ�������ַ����������
 3.�����󣬻�ȡ����ƥ�����档
 4.ͨ������Է��Ϲ�����ִ����в���������ȡ����
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ��ȡ
{
	public static void main(String[] args)
	{
		getDemo();
	}

	public static void getDemo()
	{
		String str = "ming tian jiu yao fang jia le,da jia��"; // ȡ������3��ĸ
		String reg = "[a-z]{4}\\b";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str); // ���棬Ҳ��Ϊƥ����
		while (m.find())
		{
			System.out.println(m.group());
			System.out.println(m.start()+"..."+m.end());//����ͷ��������β��0�Ǳ꿪ʼ
		}

		// str="123456";
		// String reg ="[1-9]\\d{4,14}";
		// �������װ�ɶ���
		// ����������Ҫ���õ��ַ������������ȡƥ��������
		// ����ƥ�����Ϳ����ö�����������ַ����ϣ��ҵ����Ϲ�����ִ�
		// System.out.println(m.matches());
		// //��ʵString���е�matches�����õľ���Pattern������ɵģ�ֻ������String������װ����������Ϊ�򵥣����ǹ��ܵ�һ
		// // group��������ƥ���Ľ��
		// boolean b=m.find();
		// System.out.println(m.group());
		// boolean b1=m.find();
		// System.out.println(m.group());
		// ȡ�Ķ���
	}
}
