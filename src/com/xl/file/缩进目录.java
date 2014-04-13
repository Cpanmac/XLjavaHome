package com.xl.file;

import java.io.File;

public class 缩进目录 {
	public static void main(String[] args)  {
		File dir = new File("d:\\src");
		showDir(dir, 0); // 一开始是0级目录
	}

	// 定义获得缩进的方法
	public static String getLevel(int level) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < level; x++) {
//			 sb.append("   "); //没一行前面都是
			// 想要不要前面的
			sb.insert(0, "---");
		}
		return sb.toString();
	}

	public static void showDir(File dir, int level)  { // 遇到1级目录就
		System.out.println(getLevel(level) + dir.getName());
		level++;
		File[] files = dir.listFiles();
		for (File name : files) {
			if (name.isDirectory())
				showDir(name, level);
			else
				System.out.println(getLevel(level) + name);
		}
	}
}
