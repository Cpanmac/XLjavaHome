package com.xl.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException { // дDemo��ʱ����ף�ʵ����Ҫtry
		FileReader fr = new FileReader("buf.txt");
		BufferedReader br = new BufferedReader(fr);
		String s = null;
		while ((s = br.readLine()) != null) { // ������Ϊ��ʱ����ѭ��
			System.out.println(s);
		}
		br.close();
	}
}
