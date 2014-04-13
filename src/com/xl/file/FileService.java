package com.xl.file;

import java.io.File;
import java.util.ArrayList;

import com.xl.util.FileUtil;

public class FileService {

	/**
	 * 查询该目录下的所有文件并打印
	 * 
	 * @param file
	 */
	public void queryAll(File file) throws RuntimeException {
		if (!file.isDirectory()) {
			throw new RuntimeException("这不是目录");
		}
		ArrayList<File> list = new ArrayList<File>();
		FileUtil.queryAll(list, file);
	}

}
