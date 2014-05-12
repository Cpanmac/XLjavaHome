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

public class ȥ��android�����ռ��ظ� {
	String content;
	String path;

	/**
	 * ���ı����ݽ��д���
	 * 
	 * @param content
	 * @return
	 */
	private String exec(String content) {
		String s = "xmlns:android=\"http://schemas.android.com/apk/res/android\"";
		int beginIndex = content.indexOf(s) + s.length();
		StringBuilder first = new StringBuilder(
				content.substring(0, beginIndex));
		// System.out.print(first.toString()); // �����һ��
		StringBuilder second = new StringBuilder(content.substring(beginIndex,
				content.length()));
		// System.out.println(second.toString()); // ����ڶ���
		// �Ƴ��ڶ�����s
		String _second = second.toString();
		_second = _second.replaceAll(s, "");
		return first.append(_second).toString();
	}

	/**
	 * ���б���������޸�
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
	 * �����ļ����в���
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
	public void �޸�android�Ĳ����ļ�() throws IOException {
		String path = "J:/Android/AndroidProject/Lonely/res/layout";
		// 1.Ҫ�޸��ļ���·��
		File file = new File(path);
		ArrayList<File> list = new ArrayList<File>();
		FileTool.queryAll(list, file, "xml");
		getContents(list);
		System.out.println("�޸ĳɹ�!");
	}
}
