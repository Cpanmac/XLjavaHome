package com.xl.基本知识;

import java.io.FileReader;
import java.io.IOException;

public class 读取java文件练习 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("2.java");
		char[] buf = new char[1024]; // 如果数据超过1024就在某一个位置回车了
		int num = 0;
		while ((num = fr.read(buf)) != -1) {
			System.out.print(new String(buf, 0, num));
		}
		fr.close();
	}
}
