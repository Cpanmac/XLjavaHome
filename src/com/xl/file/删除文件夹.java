package com.xl.file;

import java.io.File;

/*
 ɾ��һ�������ݵ�Ŀ¼��
 ɾ��ԭ��
 ��window��ɾ��Ŀ¼�Ǵ���������ɾ���ġ�

 */
public class ɾ���ļ��� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/abc");
		System.out.println(f.delete()); // �������ֻ��ɾ���յ�Ŀ¼
		removeDir(f);
	}

	public static void removeDir(File dir) {
		File[] files = dir.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (!files[x].isHidden() && files[x].isDirectory()) // ��Ҫ�ж��Ƿ������صģ�������ɾ
				removeDir(files[x]);
			else
				System.out.println(files[x].toString() + ": :"
						+ files[x].delete());
		}
		System.out.println(dir + "::dir::" + dir.delete()); // �����Լ�ɾ����
	}

}
