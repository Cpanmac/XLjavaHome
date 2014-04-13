package com.xl.a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class 生成年份 {

	
	public void year() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\桌面\\1.txt"));
		int num = 2013;
		int conut = 0;
		StringBuilder sb = new StringBuilder();
		String s;
		for (; num > 1979; num--, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "年</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void month() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\桌面\\1.txt"));
		int num = 1;
		int conut = 0;
		StringBuilder sb = new StringBuilder();
		String s;
		for (; num < 13; num++, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "月</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void day() throws IOException // 生成1到31天
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\桌面\\1.txt"));
		int num = 1;
		int conut = 0;
		String s;
		for (; num < 32; num++, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "天</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void city() throws IOException {
		String[] str = { "武汉市", "黄石市", "襄樊市", "十堰市", "荆州市", "宜昌市", "荆门市",
				"鄂州市", " 孝感市", "黄冈市", " 咸宁市", "随州市", " 恩施市", "仙桃市", " 潜江市",
				"天门市" };
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\桌面\\1.txt"));
		int num = 0;
		int conut = 0;
		String s;
		for (; num < str.length; num++, conut++) {
			s = "<option value=\"" + conut + "\">" + str[num] + "</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();

	}

}
