package com.xl.file;

import java.io.File;

/*
 �г�ָ��Ŀ¼���ļ������ļ��У�������¼�е����ݡ�
 ˼·���������ڱ����ļ��еĹ��ܣ��������ڲ������ļ��У������Լ���������
 
 �ݹ�Ҫע�⣺
 �޶�����
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File f = new File("E:\\xl");
		showDir(f);
	}

	public static void showDir(File dir) {
		File[] files = dir.listFiles();
		int num=0;
		for (File name : files) {    //���Ի���x<files.length;
			System.out.println(name + "  ");
			num++;
			if (name.isDirectory()) {  //�ж��Ƿ���Ŀ¼
				showDir(name);
			}else if(num%10==0){  
				System.out.println();
			}
		}

	}
}
