package com.project.�鿴�ļ��еĴ�С;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.xl.file.FileService;
import com.xl.util.FileTool;

public class �鿴�ļ��еĴ�С {
	private File dir = new File("L:");
	private List<File> fileList = new ArrayList<File>();
	private FileService service = new FileService();
	String filePath;
	
	@Before
	public void init() {
		Scanner sr = new Scanner(System.in);
		System.out.println("������Ŀ¼");
		filePath = sr.nextLine().trim();
	}
	
	@Test
	public void test1() {
		dir = new File(filePath);
		File[] file = dir.listFiles();
		fileList.addAll(Arrays.asList(file));
		print(fileList);
	}
	
	private void print(List<File> fileList) {
		for (File file : fileList) {
			if (file.isDirectory()) {
				System.out.println(file.getPath() + "\t"
				        + FileTool.getSize(service.getFileSize(file)) + "\t"
				        + service.getFileSize(file));
			} else {
				System.out.println(file.getPath() + "\t" + FileTool.getSize(file.length()) + "\t"
				        + file.length());
			}
		}
	}
}
