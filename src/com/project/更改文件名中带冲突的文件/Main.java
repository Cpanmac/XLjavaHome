package com.project.更改文件名中带冲突的文件;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * @Description 解决文件冲突
 * 
 * @author 徐立
 *
 * @date 2014-6-2
 */
public class Main {
	/** 要遍历的目录 */
	private File file;
	/** 所有文件 */
	private List<File> allFile;
	/** 失败文件 */
	private List<File> failFileList;
	/** 成功的文件	 */
	private List<File> successFileList;
	@Before
	public void init() {
		Scanner sr = new Scanner(System.in);
		System.out.println("请输入路径:");
		String _file = sr.next().trim();
		file = new File(_file);
		allFile = new ArrayList<File>();
		failFileList = new ArrayList<File>();
		successFileList = new ArrayList<File>();
		if (!file.exists() || !file.isDirectory()) {
			System.out.println("不是目录！");
			init();
		}
		// file = new File("I:/我的快盘/mywork");
		// file = new File("I:/我的快盘/mywork/javaSE");
	}
	
	@Test
	public void initTest() {
		queryList(allFile, file);
		System.out.println("成功:" + successFileList.size());
		System.out.println("失败：" + failFileList.size());
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
				if (fileName.contains("(冲突")) {
					fileName = fileName.replaceAll("\\(.*\\)", "");
					File _file = new File(fileName);
					if (_file.exists()) {
						_file.delete();
					}
					boolean flag = file.renameTo(_file);
					if (flag) {
						System.out.println(file.getAbsolutePath() + "重命名成功。");
						successFileList.add(_file);
					} else {
						System.out.println(file.getAbsolutePath() + "命名失败。");
						failFileList.add(_file);
					}
				}
				return list;
			}
		}
		return null;
	}
}
