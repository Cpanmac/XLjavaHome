package com.xl.a;

import java.io.File;
import java.util.Scanner;

public class 删除非java文件 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("请输入要删除的目录：");
		Scanner sr = new Scanner(System.in);
		String dirPath = sr.nextLine();
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				String name = f.getName();
				if (!(name.endsWith(".java"))) {
					if (f.delete()) {
						System.out.println(f.getName() + "删除成功！");

					}
				}
			}
		}
	}

}
