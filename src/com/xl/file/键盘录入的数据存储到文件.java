package com.xl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*1.
 源：键盘录入
 目的：控制台。
 2.需求：把键盘录入的数据存储到文件中
 源：键盘。
 目的：文件
 3.需求：把一个文件打印到控制台上
 源：文件
 目的：控制台
 
流操作的基本规律：
最痛苦的就是流对象有很多，不知道该用哪一个。
通过三个明确来完成。
1.明确源和目的。
	源：输入流。InputStream Reader
	目的：输出流。OutputStream Writer.
2.操作的数据是否是纯文本。
	是：字符流。
	不是：字节流。  //可以操作图片、视频
3.当体系明确后，再明确要使用哪个具体的对象。
	通过设备来进行区分：
	源设备：内存，硬盘，键盘
	目的设备：内存，硬盘，控制台。
 *
 *
 */
public class 键盘录入的数据存储到文件
{
	public static void main(String[] args) throws IOException
	{
		/*
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("out.txt")));

		String line = null;
		while ((line = bufr.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\n也可以,不过不能跨平台
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
		*/
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(
				"out.txt")));       //System.in替换
	
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				System.out));   //new FileOutputStream("out.txt")

		String line = null;
		while ((line = bufr.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\n也可以,不过不能跨平台
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
	}
}
