package com.xl.file;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException { // Ϊ����ʾ���
		// ����һ����ȡ��������ƶ����Ƶ��ļ��������Ҫ��֤�ļ����Ѿ����ڵģ���������ڻᷢ��FileNotFoundException
		FileReader fr = new FileReader("demo.txt");
		char c;
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
		fr.close();
	}
}
