package com.xl.����֪ʶ;

import java.io.FileReader;
import java.io.IOException;

public class ��ȡjava�ļ���ϰ {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("2.java");
		char[] buf = new char[1024]; // ������ݳ���1024����ĳһ��λ�ûس���
		int num = 0;
		while ((num = fr.read(buf)) != -1) {
			System.out.print(new String(buf, 0, num));
		}
		fr.close();
	}
}
