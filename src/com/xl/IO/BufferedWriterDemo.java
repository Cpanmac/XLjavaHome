package com.xl.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("buf.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("as\r\ndfd");
		bw.newLine();
		for (int x = 1; x < 5; x++) {
			bw.write("abcd" + x);
			bw.newLine();
			bw.flush(); // дһ��ˢһ�Σ���ͣ�磡
		}
		bw.flush(); // ֻҪ�õ�����������Ҫˢ��
		bw.close(); // ��ʵ�رջ����������ڹرջ������е�������
		// fw.close(); //�����������д��!
	}
}
