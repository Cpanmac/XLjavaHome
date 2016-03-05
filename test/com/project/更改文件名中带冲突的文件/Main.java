package com.project.�����ļ����д���ͻ���ļ�;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * @Description ����ļ���ͻ
 * 
 * @author ����
 *
 * @date 2014-6-2
 */
public class Main {
	/** Ҫ������Ŀ¼ */
	private File file;
	/** �����ļ� */
	private List<File> allFile;
	/** ʧ���ļ� */
	private List<File> failFileList;
	/** �ɹ����ļ�	 */
	private List<File> successFileList;
	@Before
	public void init() {
		Scanner sr = new Scanner(System.in);
		System.out.println("������·��:");
		String _file = sr.next().trim();
		file = new File(_file);
		allFile = new ArrayList<File>();
		failFileList = new ArrayList<File>();
		successFileList = new ArrayList<File>();
		if (!file.exists() || !file.isDirectory()) {
			System.out.println("����Ŀ¼��");
			init();
		}
		// file = new File("I:/�ҵĿ���/mywork");
		// file = new File("I:/�ҵĿ���/mywork/javaSE");
	}
	
	@Test
	public void initTest() {
		queryList(allFile, file);
		System.out.println("�ɹ�:" + successFileList.size());
		System.out.println("ʧ�ܣ�" + failFileList.size());
	}
	
	private List<File> queryList(List<File> list, File file) {
		if (file != null) {
			if (file.isDirectory()) {
				File[] _list = file.listFiles();
				for (File _file : _list) {
					queryList(list, _file);
				}
			} else if (file.isFile()) {
				String fileName = file.getAbsolutePath();
				if (fileName.contains("(��ͻ")) {
					fileName = fileName.replaceAll("\\(.*\\)", "");
					File _file = new File(fileName);
					if (_file.exists()) {
						_file.delete();
					}
					boolean flag = file.renameTo(_file);
					if (flag) {
						System.out.println(file.getAbsolutePath() + "�������ɹ���");
						successFileList.add(_file);
					} else {
						System.out.println(file.getAbsolutePath() + "����ʧ�ܡ�");
						failFileList.add(_file);
					}
				}
				return list;
			}
		}
		return null;
	}
}
