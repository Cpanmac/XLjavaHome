package com.xl.project.��������վ;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.xl.util.RegTool;

/**
 * @Decription 1.�����ı�<br/>
 *             2.ͨ������ƥ����վ��<br/>
 *             3.����վ
 * 
 * @date 2014-5-3
 * 
 * @author ����
 * 
 */
public class ��������վ {
	private StringBuffer content = new StringBuffer();
	private Scanner sr = new Scanner(System.in);
	/** ��վ������ */
	private String reg = "http.+";
	/** �洢��վ�ļ��� */
	String[] strs = null;

	@SuppressWarnings("unused")
	@Test
	public void before() throws IOException {

		System.out.println("ճ����Ҫ����վ���ı�������-1����");
		String s = null;
		while (!"-1".equalsIgnoreCase(s = sr.next())) {
			content.append(s + "\r\n");
		}
		strs = RegTool.getContent(content.toString(), reg);
		System.out.println("�����"+strs.length+"����վ");
//		for (String _s : strs) {
//			Desktop.getDesktop().browse(URI.create(_s));
//		}
	}
}
