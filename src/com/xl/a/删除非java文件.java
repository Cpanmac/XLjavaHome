package com.xl.a;

import java.io.File;
import java.util.Scanner;

public class ɾ����java�ļ� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("������Ҫɾ����Ŀ¼��");
		Scanner sr = new Scanner(System.in);
		String dirPath = sr.nextLine();
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				String name = f.getName();
				if (!(name.endsWith(".java"))) {
					if (f.delete()) {
						System.out.println(f.getName() + "ɾ���ɹ���");

					}
				}
			}
		}
	}

}
