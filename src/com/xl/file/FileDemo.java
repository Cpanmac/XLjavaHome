package com.xl.file;

//
//1.������
//boolean createNewFile();��ָ��λ�ô����ļ���������ļ��Ѿ���ָ��λ���Ѿ����ڣ�����false
//��������������������һ�����ͻḲ�ǡ�
//2.ɾ����
//bealean delete();
//void deteOnExit(): ���˳��������ʱ��ɾ��
//canExcute:  �Ƿ��ִ��
//compareTo:  �Ƚ�
//
//3.�жϣ�
//boolean exists() �ļ��Ƿ���ڣ�һ�㶼��ʼҪ�ж�һ��
//isFile()
//isDirectory()
//isHiddent()
//isAbsolute()
//
//4.��ȡ��Ϣ
//getName();
//getPath()
// File getAbsoluteFile() 
//          ���ش˳���·�����ľ���·������ʽ�� 
// String getAbsolutePath() 
//          ���ش˳���·�����ľ���·�����ַ����� 
//
//���ǵ�ԭ����ɾ���ٴ�����ԭ�ļ�һ�����ֵ��ļ�
//
//boolean renameTo(File dest) �Ƚ�����
//���������˳���·������ʾ���ļ��� 

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.filechooser.FileSystemView;

import org.junit.Test;

import com.xl.util.FileUtil;

public class FileDemo {

	@Test
	public void test1() throws IOException {
		File file = new File(FileUtil.getCurrentPath(this), "123.txt");
		String s = "��˧���";
		FileUtil.write(file, s);
	}

	public static void method_1() throws IOException {
		File f = new File("file.txt");
		// ��ֹ�쳣�޷��ص����������߳����ڲ�����ʱ��
		f.deleteOnExit();
		// System.out.println(f.canExecute());
		// System.out.println(f.exists());
		// �����ļ���
		File dir = new File("xl");
		System.out.println("mkdir:" + dir.mkdir()); // true
		System.out.println("mkdir:" + dir.mkdir()); // false
		// �����༶�ļ��С�
		File dirs = new File("xl\\xl");
		System.out.println(dirs.mkdirs());
	}

	public static void method_3() throws IOException {
		File f = new File("file.txt");
		// ��ס���ж��ļ������Ƿ����ļ�����Ŀ��ʱ���������ж��ļ��Ƿ����
		System.out.println(f.exists());// false
		System.out.println("dir:" + f.isDirectory());// false
		System.out.println("File:" + f.isFile());// false
		// �����ļ�
		// f.createNewFile();
		// ����Ŀ¼��Ŀ¼����Ҳ���Դ�txt
		// f.mkdir();
		// f.mkdirs();
		// ����������Ӳ���б����ص��ļ�������ʧ��
		// �ж��Ƿ��Ǿ���·���������̷����Ǿ���·������ʹ������Ҳ����true
		// System.out.println(f.isAbsolute());
	}

	public static void method_4() {
		// ���������һ���ģ���Ϊ·��������Ǿ��Ե�,���Բ����쳣
		File f = new File("c:/a.txt");
		System.out.println("path:" + f.getPath());
		System.out.println("abspath:" + f.getAbsolutePath());

		// �ļ������ڣ�·��Ҳ�ܵõ�
		// File f = new File("file.txt");
		System.out.println("path:" + f.getPath()); // ����file.txt,���·��
		System.out.println("abspath:" + f.getAbsolutePath()); // ����·��
		// ���ؾ���·���ĸ�Ŀ¼
		// System.out.println("parent:"+f.getParent());//��ʱnull���������һ��Ŀ¼�ͷ��ؽ��
		// ��������޸ĵ�ʱ��long����
		// System.out.println(f.lastModified());//1357820463062/

	}

	public void method_5() throws IOException {
		// �������ļ������Ǽ���
		File f1 = new File("D:\\text.java");
		File f2 = new File("c:\\haha.java");
		System.out.println("rename:" + f2.renameTo(f1));
	}

	@Test
	public void ���Ա���() throws IOException {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("1.txt");
		BufferedInputStream bis = new BufferedInputStream(is);
		while (true) {
			int ch = bis.read();
			System.out.println(ch + "  " + (char) ch);
			if (ch < 0) {
				break;
			}
		}
	}

	@Test
	public void ��ѯָ��Ŀ¼�������ļ�() {
		FileService service = new FileService();
		File file = new File("O:/");
		service.queryAll(file);
	}

	@Test
	public void �õ������·��() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File file = fsv.getHomeDirectory();
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
	}

	@Test
	public void ���Ŀ¼������() throws IOException {
		File file = new File(FileSystemView.getFileSystemView()
				.getHomeDirectory(), "5/" + "a.txt");
		FileUtil.write(file, "����");
	}
}
