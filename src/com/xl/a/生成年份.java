package com.xl.a;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ������� {

	
	public void year() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\����\\1.txt"));
		int num = 2013;
		int conut = 0;
		StringBuilder sb = new StringBuilder();
		String s;
		for (; num > 1979; num--, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "��</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void month() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\����\\1.txt"));
		int num = 1;
		int conut = 0;
		StringBuilder sb = new StringBuilder();
		String s;
		for (; num < 13; num++, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "��</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void day() throws IOException // ����1��31��
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\����\\1.txt"));
		int num = 1;
		int conut = 0;
		String s;
		for (; num < 32; num++, conut++) {
			s = "<option value=\"" + conut + "\">" + num + "��</option>";
			bw.write(s);
			bw.flush();
			System.out.println(s);
		}

		bw.close();
	}

	public void city() throws IOException {
		String[] str = { "�人��", "��ʯ��", "�差��", "ʮ����", "������", "�˲���", "������",
				"������", " Т����", "�Ƹ���", " ������", "������", " ��ʩ��", "������", " Ǳ����",
				"������" };
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"c:\\Documents and Settings\\Administrator\\����\\1.txt"));
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
