package com.xl;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xl.util.FileTool;
import com.xl.util.StreamTool;

public class 去掉android命名空间重复 {
	String content;
	String path;

	/**
	 * 对文本内容进行处理
	 * 
	 * @param content
	 * @return
	 */
	private String exec(String content) {
		String s = "xmlns:android=\"http://schemas.android.com/apk/res/android\"";
		int beginIndex = content.indexOf(s) + s.length();
		StringBuilder first = new StringBuilder(
				content.substring(0, beginIndex));
		// System.out.print(first.toString()); // 输出第一段
		StringBuilder second = new StringBuilder(content.substring(beginIndex,
				content.length()));
		// System.out.println(second.toString()); // 输出第二段
		// 移除第二段中s
		String _second = second.toString();
		_second = _second.replaceAll(s, "");
		return first.append(_second).toString();
	}

	/**
	 * 对列表进行批量修改
	 * 
	 * @param list
	 * @throws IOException
	 */
	private void getContents(List<File> list) throws IOException {
		int i = 1;
		for (File f : list) {
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			String content = StreamTool.getContent(is);
			content = exec(content);
			FileTool.write(f, content);
		}
	}

	/**
	 * 单个文件进行测试
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String path = "J:/Android/AndroidProject/Lonely/res/layout/app_hello.xml";
		File file = new File(path);
		System.out.println(file.getPath());
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\r\n");
		}
		content = sb.toString();
		System.out.println(content);
	}

	@Test
	public void 修复android的布局文件() throws IOException {
		String path = "J:/Android/AndroidProject/Lonely/res/layout";
		// 1.要修改文件的路径
		File file = new File(path);
		ArrayList<File> list = new ArrayList<File>();
		FileTool.queryAll(list, file, "xml");
		getContents(list);
		System.out.println("修改成功!");
	}
}
