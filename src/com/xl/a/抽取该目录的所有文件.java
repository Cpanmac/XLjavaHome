package com.xl.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.junit.Test;

public class ��ȡ��Ŀ¼�������ļ� {

	public File f1 = null;
	public File f2 = null;
	public Scanner sr = new Scanner(System.in);

	@Test
	public void test() throws IOException, ClassNotFoundException {
		Class cla = Class.forName("�����Ĺ��߰�.��ȡ��Ŀ¼�������ļ�");
		��ȡ��Ŀ¼�������ļ� sb = new ��ȡ��Ŀ¼�������ļ�();
		f1 = new File(
				"C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0");
		f2 = new File("C:\\Documents and Settings\\Administrator\\����\\xl");
		print(f1);
	}

	// ��ʾ�û�����
	public void tishi() {
		System.out.println("������Ŀ¼Ҫ���Ƶ�Ŀ¼��");
		String s1 = sr.next();
		File f1 = new File(s1);
		System.out.println("������Ҫ��ŵ�·��:");
		String s2 = sr.next();
		File f2 = new File(s2);

	}

	public void print(File file) throws IOException { // �ݹ����
		if (file != null) { // �ж϶����Ƿ�Ϊ��
			if (file.isDirectory()) { // �����Ŀ¼
				File f[] = file.listFiles(); // �г�ȫ�����ļ�
				if (f != null) { // �жϴ�Ŀ¼�ܷ��г�
					for (int i = 0; i < f.length; i++) {
						print(f[i]); // ��Ϊ����·���п�����Ŀ¼�����ԣ������ж�
					}
				}
			} else {
				System.out.println(file);
//				method(file, f2);
				method(file);
			}
		}
	}
	
	public void method(File src) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(src)));
			if (!(f2.exists())) {
				if (f2.mkdir()) {
					System.out.println("Ŀ��·�������ɹ���");
//					method(src, f2);
				}
			} else {
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f2)));
//				BufferedOutputStream bw=new BufferedOutputStream(new FileOutputStream(f2+"\\1.txt"));
				System.out.println(f2);
				String s = null;
				StringBuffer sb = null;
				while (true) {
					s = br.readLine();
					sb.append(s);
					System.out.println(s);
					if (s == null) {
						break;
					}
				}
				System.out.println(sb);
		}
	}

	// �����ļ�
	public void method(File src, File aim) throws IOException {
		if (src.isFile()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(src)));
			if (!(aim.exists())) {
				if (aim.mkdir()) {
					System.out.println("Ŀ��·�������ɹ���");
					method(src, aim);
				}
			} else {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(aim)));
				String s = null;
				StringBuffer sb = null;
				while (true) {
					s = br.readLine();
					sb.append(s);
					System.out.println(s);
					if (s == null) {
						break;
					}
				}
				System.out.println(sb);
			}
		}
	}
}
