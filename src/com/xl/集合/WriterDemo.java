package com.xl.¼¯ºÏ;

import java.io.FileWriter;
import java.io.IOException;
public class WriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("demo.txt", true);
		fw.write("nihao");
		fw.write("\r\n¹þà¶");
		fw.close();
	}
}
