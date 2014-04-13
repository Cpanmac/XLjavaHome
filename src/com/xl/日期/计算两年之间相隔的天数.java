package com.xl.日期;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class 计算两年之间相隔的天数 {
	@Test
	public void test() {
		// 获取日历实例
		Calendar calendar = Calendar.getInstance();
		// 用当前时间初始化日历时间
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		// 获得月份要加1
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int hour = calendar.get(Calendar.HOUR); // 12小时制
		int minute = calendar.get(Calendar.MINUTE);
		hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时制。
		// 获取当前星期几，要-1
		Calendar c2 = Calendar.getInstance();
		c2.set(2001, 0, 1);
		System.out.println(calendar.compareTo(c2));

	}

	@Test
	public void test2() {
		System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s", " 日", "一", "二", "三",
				"四", "五", "六");
		Calendar c = Calendar.getInstance();
		// 将日历翻到2004年1月1日，这里月的数字要是0，表示一月
		c.set(2004, 0, 1);
		// 获取星期几
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(week);
		String[] str = new String[week + 31]; // 存放号码的一维数组
		// System.out.println(week);
		System.out.println();
		int count = 0;
		for (int x = 0; x < week; x++) {
			System.out.printf("%6s", "----");
			count++;
		}
		for (int i = 1; i < str.length; i++) {
			System.out.printf("%2s%-5d", " ", i);
			count++;
			if (count % 7 == 0) {
				System.out.println();
			}
		}
	}

}
