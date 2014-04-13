package com.xl.url;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.xl.util.FileUtil;

public class URLDemo {
	@Test
	public void testUrl() throws Exception {
		String s = "http://www.hao123.com.com/juruboba/";
		URL url = new URL(s);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(5000); // 5���ȡ�����ͳ�ʱ

		System.out.println(url.getProtocol() + url.getHost());
		conn.setRequestProperty("if-modifyed-since", System.currentTimeMillis()
				+ ""); // FIXME �������������ɶ��

		System.out.println(conn.getHeaderFields());
		// HTTPURLӵ�и���ķ���
		int code = conn.getResponseCode();// 200Ϊ���سɹ�,404�Ҳ���ҳ��,500����������
		System.out.println("response״̬��" + code);
		System.out.println("����ʽ:" + conn.getRequestMethod());
		System.out.println("���뷽ʽ:" + conn.getHeaderField("Content-Type"));
		System.out.println(conn.getURL());
	}

	@Test
	public void testGetURL() throws IOException {
		URL u = getURL(FileUtil.class, "/");
		System.out.println(u); // file:/D:/mywork/javaSE/bin/util/1
		System.out.println(u.getContent()); // �������Դjava.io.BufferedInputStream@983d95
		System.out.println(u.getDefaultPort()); // -1
		System.out.println(u.getPath()); // /D:/mywork/javaSE/bin/util/1
		System.out.println(u.getFile()); // /D:/mywork/javaSE/bin/util/1
		File file = new File(u.getFile());
		System.out.println(file.getAbsolutePath());// D:\mywork\javaSE\bin\\util
		File parent = file.getParentFile().getParentFile();
		System.out.println(parent); // ��ǰ���̵ľ���·��D:\mywork\javaSE
	}

	/**
	 * ��ȡ����Ŀ¼����Դ�ļ���URL
	 * 
	 * @param clazz
	 *            ��
	 * @param resource
	 *            1.null��""��/:���ز������Լ���URL<br/>
	 *            2.:��ǰclasspath�ľ���·��
	 * @return URL .class�ļ���Ӧ�ľ���·��
	 */
	public static URL getURL(Class clazz, String resource) {
		if (resource == null) {
			resource = "";
		}
		return clazz.getResource(resource);
	}

}
