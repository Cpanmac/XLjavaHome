package com.xl.file;

import java.io.File;

/*
 列出指定目录下文件或者文件夹，包含自录中的内容。
 思路：定义用于遍历文件夹的功能，当碰到内部还有文件夹，调用自己继续遍历
 
 递归要注意：
 限定条件
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File f = new File("E:\\xl");
		showDir(f);
	}

	public static void showDir(File dir) {
		File[] files = dir.listFiles();
		int num=0;
		for (File name : files) {    //可以换成x<files.length;
			System.out.println(name + "  ");
			num++;
			if (name.isDirectory()) {  //判断是否是目录
				showDir(name);
			}else if(num%10==0){  
				System.out.println();
			}
		}

	}
}
