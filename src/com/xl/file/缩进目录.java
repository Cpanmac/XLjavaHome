package com.xl.file;

import java.io.File;

public class ����Ŀ¼ {
	public static void main(String[] args)  {
		File dir = new File("d:\\src");
		showDir(dir, 0); // һ��ʼ��0��Ŀ¼
	}

	// �����������ķ���
	public static String getLevel(int level) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < level; x++) {
//			 sb.append("   "); //ûһ��ǰ�涼��
			// ��Ҫ��Ҫǰ���
			sb.insert(0, "---");
		}
		return sb.toString();
	}

	public static void showDir(File dir, int level)  { // ����1��Ŀ¼��
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
