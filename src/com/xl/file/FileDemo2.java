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
		String[] arr = dir.list(new FilenameFilter() // �ӿڿ���new����
				{

					@Override
					public boolean accept(File dir, String name) { // dir�����ϼ�Ŀ¼��name�����ļ���
						// TODO Auto-generated method stub
						System.out.print("dir" + dir + "..." + name); // ��ӡ�����е�Ŀ¼���ļ�����
						return name.endsWith(".txt");
					}
				});
		System.out.println();
		System.out.print("len:" + arr.length); // ��return��true����˼�ǵ�ǰ�ļ�������Ҫ�ģ���Ϊfalseʱ��0
		for (String name : arr) {
			System.out.print(name + " ");
		}

	}

	public static void listDemo() {
		File f = new File("c:\\abc.txt");
		// ��ȡc��Ŀ¼�������ļ���
		String[] names = f.list(); // ����list����File��������װ��Ŀ¼����Ŀ¼������ڣ�������ļ����쳣
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
