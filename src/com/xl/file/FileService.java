package com.xl.file;

import java.io.File;
import java.util.ArrayList;

import com.xl.util.FileUtil;

public class FileService {

	/**
	 * ��ѯ��Ŀ¼�µ������ļ�����ӡ
	 * 
	 * @param file
	 */
	public void queryAll(File file) throws RuntimeException {
		if (!file.isDirectory()) {
			throw new RuntimeException("�ⲻ��Ŀ¼");
		}
		ArrayList<File> list = new ArrayList<File>();
		FileUtil.queryAll(list, file);
	}

}
