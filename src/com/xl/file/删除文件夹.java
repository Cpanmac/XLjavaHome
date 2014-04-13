package com.xl.file;

import java.io.File;

/*
 删除一个带内容的目录。
 删除原理：
 在window中删除目录是从里面往外删除的。

 */
public class 删除文件夹 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/abc");
		System.out.println(f.delete()); // 这个操作只能删除空的目录
		removeDir(f);
	}

	public static void removeDir(File dir) {
		File[] files = dir.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (!files[x].isHidden() && files[x].isDirectory()) // 先要判断是否是隐藏的，避免误删
				removeDir(files[x]);
			else
				System.out.println(files[x].toString() + ": :"
						+ files[x].delete());
		}
		System.out.println(dir + "::dir::" + dir.delete()); // 最后把自己删除掉
	}

}
