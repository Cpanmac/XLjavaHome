package com.xl.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.xl.util.RegTool;

/**
 * @Decription ((())()) ��һ���������ǵ�һ�飬�ڶ����������ǵڶ��顣�ܹ����������ž��м���
 * 
 * @date 2014-1-12
 * 
 * @author ����
 * 
 */
public class RegexDemo {

	/**
	 * ���ظ���ȥ�� <br/>
	 * $1�ܻ�ȡ��һ��
	 */
	@Test
	public void replaceAllDemo() {
		String str = "111232233333"; // ��һ����ĸ������
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}

	/**
	 * ��������[\\u4E00-\\u9FFF]+
	 * 
	 */
	@Test
	public void ƥ������() {
		String str = "zh�ڷ��޷�angsa�й�n.lisi.wangwu";
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
	public void ��������() {
		String s = "<span>a</span><span>b</span>";
		getLazy(s, new Lazy() {

			@Override
			public String getReg() {
				// �������
				return "<span.+span>";
			}
		});

		getLazy(s, new Lazy() {

			@Override
			public String getReg() {
				// ���裬ƥ�����ĺ�������ʺž���
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
