package com.xl.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class 读取转换流 // InputStreamReader
{
	public static void main(String[] args) throws IOException
	{
		/*
		 * // 获取键盘录入对象。 InputStream in = System.in; // 将字节流对象转化成字符流对象
		 * InputStreamReader isr = new InputStreamReader(in); //
		 * 以后缀为主，是Reader的子类 // 为了提高效率，将字符串进行缓冲区技术高效操作。使用BufferedReader
		 * BufferedReader bufr = new BufferedReader(isr); String line = null;
		 * while ((line = bufr.readLine()) != null) { if ("over".equals(line))
		 * // 定义结束标记 break; System.out.println(line.toUpperCase()); //
		 * 将输入的转化成大写方便区分 } // bufr.close(); }
		 */
System.setIn(new FileInputStream("1.java"));  //改变源
System.setOut(new PrintStream("zzz.txt"));  //改变目的
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out); // 转化成输出
		BufferedWriter bufw = new BufferedWriter(osw); // 用newLine() 跨平台换行
		String line = null;
		while ((line = br.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\n也可以,不过不能跨平台
			bufw.newLine();
			bufw.flush();
		}
		osw.close();
		br.close();
		bufw.close();
	}
}
