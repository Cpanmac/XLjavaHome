package com.xl.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.xl.util.RegTool;

/**
 * @Decription ((())()) 第一个左括号是第一组，第二个左括号是第二组。总共几个左括号就有几组
 * 
 * @date 2014-1-12
 * 
 * @author 徐立
 * 
 */
public class RegexDemo {

	/**
	 * 将重复的去掉 <br/>
	 * $1能获取第一组
	 */
	@Test
	public void replaceAllDemo() {
		String str = "111232233333"; // 有一对字母和数字
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}

	/**
	 * 测试中文[\\u4E00-\\u9FFF]+
	 * 
	 */
	@Test
	public void 匹配中文() {
		String str = "zh挖坟无法angsa中国n.lisi.wangwu";
		String reg = "[\\u4E00-\\u9FFF]+";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			sb.append(m.group() + "\n");
		}
		System.out.println(sb.toString());
	}

	@Test
	public void 懒惰量词() {
		String s = "<span>a</span><span>b</span>";
		getLazy(s, new Lazy() {

			@Override
			public String getReg() {
				// 输出所有
				return "<span.+span>";
			}
		});

		getLazy(s, new Lazy() {

			@Override
			public String getReg() {
				// 懒惰，匹配多个的后面加上问号就是
				return "<span.+?span>";
			}
		});
	}

	private interface Lazy {
		String getReg();
	}

	private void getLazy(String content, Lazy l) {
		Pattern p = Pattern.compile(l.getReg());
		Matcher m = p.matcher(content);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
