package com.xl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 复制文件
 源：因为是源，所以使用读取流InputStream Reader
 是不是操作文本文件？是，Reader
 接下来明确对象。 硬盘。上的一个文件 
 Reader体系中可以操作文件的对象FileReader


 目的：OutputStream Writer
 是否是纯文本。
 是！Writer.
 设备：硬盘，一个文件
 Writer体系可以操作文件的对象是FileWriter

 .*/
public class 将一个文本文件数据存储到另一个文件
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("out.txt");
		BufferedReader bfr=new BufferedReader(fr);
		FileWriter fw=new FileWriter("hae.txt");
		BufferedWriter bfw=new BufferedWriter(fw);
		String line=null;
		while ((line=bfr.readLine())!=null){
			bfw.write(line);
		}
		bfw.close();
		bfr.close();
	}
}
