package com.xl.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
	public static void main(String[] args) { // дDemo��ʱ����ף�ʵ����Ҫtry
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("buf.txt");
			br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) { // ������Ϊ��ʱ����ѭ��
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
