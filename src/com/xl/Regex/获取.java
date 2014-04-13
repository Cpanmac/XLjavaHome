package com.xl.Regex;

/*
 将字符串中的符合规则的字串取出。
 操作步骤：
 1.将正则表达式封装成对象。
 2.让正则对象和要操作的字符串相关联。
 3.关联后，获取正则匹配引擎。
 4.通过引擎对符合规则的字串进行操作。比如取出。
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 获取
{
	public static void main(String[] args)
	{
		getDemo();
	}

	public static void getDemo()
	{
		String str = "ming tian jiu yao fang jia le,da jia。"; // 取出连续3字母
		String reg = "[a-z]{4}\\b";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str); // 引擎，也成为匹配器
		while (m.find())
		{
			System.out.println(m.group());
			System.out.println(m.start()+"..."+m.end());//包含头，不包含尾从0角标开始
		}

		// str="123456";
		// String reg ="[1-9]\\d{4,14}";
		// 将规则封装成对象
		// 让正则对象和要作用的字符串相关联。获取匹配器对象
		// 有了匹配器就可以用多个规则作用字符串上，找到符合规则的字串
		// System.out.println(m.matches());
		// //其实String类中的matches方法用的就是Pattern对象完成的，只不过被String方法封装后，用起来较为简单，但是功能单一
		// // group方法用于匹配后的结果
		// boolean b=m.find();
		// System.out.println(m.group());
		// boolean b1=m.find();
		// System.out.println(m.group());
		// 取的动作
	}
}
