package com.xl.IO;

import java.io.File;

public class 分隔符 {
	public static void main(String args[]) {
		System.out.println("pathSeparator：" + File.pathSeparator); // 调用静态常量
		System.out.println("pathSeparatorChar" + File.pathSeparatorChar);
		System.out.println("separator：" + File.separator); // 调用静态常量
		System.out.println("separatorChar:"+File.separatorChar);
		System.out.println(";");
	}
}