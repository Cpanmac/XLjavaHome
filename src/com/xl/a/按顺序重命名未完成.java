package com.xl.a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class 按顺序重命名未完成 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("请输出要重命名的目录：");
		Scanner sr = new Scanner(System.in);
		// String s = sr.next();
		String s = "C:\\Documents and Settings\\Administrator\\桌面\\新建文件夹 (2)";
		File f = new File(s);
		print(f);
	}

	public static void print(File file) throws IOException { // 递归调用
		if (file != null) { // 判断对象是否为空
			if (file.isDirectory()) { // 如果是目录
				File f[] = file.listFiles(); // 列出全部的文件
				if (f != null) { // 判断此目录能否列出
					for (int i = 0; i < f.length; i++) {
						print(f[i]); // 因为给的路径有可能是目录，所以，继续判断
					}
				}
			} else {
				// 获取父目录
				String parentPath = file.getParent();
				// System.out.println(parentPath);
				// 获取文件名
				String name = file.getName();
				String kk = name.substring(0, 2);
				name = name.replaceAll("\\.", kk + "\\.");
				file.renameTo(new File(parentPath + name));
				System.out.println("重命名成功");
			}
		}
	}

}
