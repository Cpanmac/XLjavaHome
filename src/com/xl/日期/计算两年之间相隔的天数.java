package com.xl.����;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ��������֮����������� {
	@Test
	public void test() {
		// ��ȡ����ʵ��
		Calendar calendar = Calendar.getInstance();
		// �õ�ǰʱ���ʼ������ʱ��
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		// ����·�Ҫ��1
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int hour = calendar.get(Calendar.HOUR); // 12Сʱ��
		int minute = calendar.get(Calendar.MINUTE);
		hour = calendar.get(Calendar.HOUR_OF_DAY); // 24Сʱ�ơ�
		// ��ȡ��ǰ���ڼ���Ҫ-1
		Calendar c2 = Calendar.getInstance();
		c2.set(2001, 0, 1);
		System.out.println(calendar.compareTo(c2));

	}

	@Test
	public void test2() {
		System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s", " ��", "һ", "��", "��",
				"��", "��", "��");
		Calendar c = Calendar.getInstance();
		// ����������2004��1��1�գ������µ�����Ҫ��0����ʾһ��
		c.set(2004, 0, 1);
		// ��ȡ���ڼ�
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(week);
		String[] str = new String[week + 31]; // ��ź����һά����
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
