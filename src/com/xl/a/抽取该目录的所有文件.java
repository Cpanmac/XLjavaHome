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

public class 抽取该目录的所有文件 {

	public File f1 = null;
	public File f2 = null;
	public Scanner sr = new Scanner(System.in);

	@Test
	public void test() throws IOException, ClassNotFoundException {
		Class cla = Class.forName("徐立的工具包.抽取该目录的所有文件");
		抽取该目录的所有文件 sb = new 抽取该目录的所有文件();
		f1 = new File(
				"C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0");
		f2 = new File("C:\\Documents and Settings\\Administrator\\桌面\\xl");
		print(f1);
	}

	// 提示用户输入
	public void tishi() {
		System.out.println("请输入目录要复制的目录：");
		String s1 = sr.next();
		File f1 = new File(s1);
		System.out.println("请输入要存放的路径:");
		String s2 = sr.next();
		File f2 = new File(s2);

	}

	public void print(File file) throws IOException { // 递归调用
		if (file != null) { // 判断对象是否为空
			if (file.isDirectory()) { // 如果是目录
				File f[] = file.listFiles(); // 列出全部的文件
				if (f != null) { // 判断此目录能否列出
					for (int i = 0; i < f.length; i++) {
						print(f[i]); // 因为给的路径有可能是目录，所以，继续判断
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
					System.out.println("目标路径创建成功！");
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

	// 关联文件
	public void method(File src, File aim) throws IOException {
		if (src.isFile()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(src)));
			if (!(aim.exists())) {
				if (aim.mkdir()) {
					System.out.println("目标路径创建成功！");
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
