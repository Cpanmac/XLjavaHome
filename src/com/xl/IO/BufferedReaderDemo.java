package com.xl.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException { // 写Demo的时候就抛，实际中要try
		FileReader fr = new FileReader("buf.txt");
		BufferedReader br = new BufferedReader(fr);
		String s = null;
		while ((s = br.readLine()) != null) { // 当内容为空时结束循环
			System.out.println(s);
		}
		br.close();
	}
}
