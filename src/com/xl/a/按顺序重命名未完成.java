package com.xl.a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ��˳��������δ��� {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("�����Ҫ��������Ŀ¼��");
		Scanner sr = new Scanner(System.in);
		// String s = sr.next();
		String s = "C:\\Documents and Settings\\Administrator\\����\\�½��ļ��� (2)";
		File f = new File(s);
		print(f);
	}

	public static void print(File file) throws IOException { // �ݹ����
		if (file != null) { // �ж϶����Ƿ�Ϊ��
			if (file.isDirectory()) { // �����Ŀ¼
				File f[] = file.listFiles(); // �г�ȫ�����ļ�
				if (f != null) { // �жϴ�Ŀ¼�ܷ��г�
					for (int i = 0; i < f.length; i++) {
						print(f[i]); // ��Ϊ����·���п�����Ŀ¼�����ԣ������ж�
					}
				}
			} else {
				// ��ȡ��Ŀ¼
				String parentPath = file.getParent();
				// System.out.println(parentPath);
				// ��ȡ�ļ���
				String name = file.getName();
				String kk = name.substring(0, 2);
				name = name.replaceAll("\\.", kk + "\\.");
				file.renameTo(new File(parentPath + name));
				System.out.println("�������ɹ�");
			}
		}
	}

}
