package com.xl.a;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateDemo {
	@Test
	public void ����ʱ��õ�12λ() {
		Date now = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmm");
		// ���2+�·�2+����2+����3
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
			// ����ʱ��õ�12λ();
			test();
		}
	}

	@Test
	public void ʱ���() {
		Timestamp t1 = new Timestamp(System.currentTimeMillis());
		System.out.println(t1);
		Timestamp t2 = new Timestamp(new Date().getTime());
		System.out.println(t2);
		System.out.println(t1 == t2);
	}

	@Test
	public void test() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis());
		System.out.println(Long.toString(System.currentTimeMillis()).substring(
				1).length());
		System.out.println(Long.toString(System.currentTimeMillis()).substring(1));
	}
}
