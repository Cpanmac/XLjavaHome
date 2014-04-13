package com.xl.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Decription ϵͳ������
 * 
 * @date 2013-12-20
 * 
 * @author ����
 * 
 */
public class SystemUtil {
	/**
	 * ִ��ϵͳ����
	 * 
	 * @param command
	 * @return InputStream
	 */
	public static InputStream exec(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
			return p.getInputStream();
		} catch (IOException e) {
			throw new RuntimeException("ִ������ʧ��");
		}
	}

	public static InputStream exec(String[] command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
			return p.getInputStream();
		} catch (IOException e) {
			throw new RuntimeException("ִ������ʧ��");
		}
	}

	/**
	 * �õ�����̨��ӡ����Ϣ
	 * 
	 * @param command
	 * @return String
	 */
	public static String getShellInfo(String command) {
		return StreamTool.getContent(exec(command));
	}

	public static void open(File file) throws IOException {
		Desktop d = Desktop.getDesktop();
		d.open(file);
	}
}
