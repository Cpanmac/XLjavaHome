package com.xl.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateDemo {
	@Test
	public void 根据时间得到12位() {
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmm");
		// 年份2+月份2+日期2+毫秒3
		// sf = new SimpleDateFormat("yyMMddsS");
		sf = new SimpleDateFormat("yyMMdd");
		String s = sf.format(now) + "000001";
		System.out.println(s);
		System.out.println(s.length());
		long i = Long.parseLong(s);
		System.out.println(i);
		s = Long.parseLong(s) + 1 + "";
		System.out.println(s);
		System.out.println(s.length());

	}

	@Test
	public void test1() {
		for (int i = 0; i <= 10; i++) {
			// 根据时间得到12位();
			test();
		}
	}

	@Test
	public void test() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis());
		System.out.println(Long.toString(System.currentTimeMillis())
				.substring(1).length());
		System.out.println(Long.toString(System.currentTimeMillis()).substring(
				1));
	}
}
