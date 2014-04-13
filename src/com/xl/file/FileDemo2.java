package com.xl.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.junit.Test;

public class FileDemo2 {
	public static void main(String[] args) {
		File dir = new File("c:\\");
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f.getName());
		}
	}

	public static void listDemo2() {
		// listRootsDemo();
		// listDemo();
		File dir = new File("D:\\");
		String[] arr = dir.list(new FilenameFilter() // 接口可以new。。
				{

					@Override
					public boolean accept(File dir, String name) { // dir就是上级目录，name就是文件名
						// TODO Auto-generated method stub
						System.out.print("dir" + dir + "..." + name); // 打印了所有的目录和文件名，
						return name.endsWith(".txt");
					}
				});
		System.out.println();
		System.out.print("len:" + arr.length); // 当return是true的意思是当前文件是我需要的，当为false时是0
		for (String name : arr) {
			System.out.print(name + " ");
		}

	}

	public static void listDemo() {
		File f = new File("c:\\abc.txt");
		// 获取c盘目录下所有文件名
		String[] names = f.list(); // 调用list方法File对象必须封装的目录，该目录必须存在，如果是文件则异常
		for (String name : names) {
			System.out.print(name);
		}
	}

	@Test
	public void listRootsDemo() {
		File[] files = File.listRoots();
		for (File f : files) {
			System.out.print(f + " ");
		}
		System.out.println();
		File file = files[0];
		files = file.listFiles();
		System.out.println(Arrays.toString(files));
	}

}
