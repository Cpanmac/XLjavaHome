package com.xl.project.批量打开网站;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.xl.util.RegTool;

/**
 * @Decription 1.输入文本<br/>
 *             2.通过正则匹配网站。<br/>
 *             3.打开网站
 * 
 * @date 2014-5-3
 * 
 * @author 徐立
 * 
 */
public class 批量打开网站 {
	private StringBuffer content = new StringBuffer();
	private Scanner sr = new Scanner(System.in);
	/** 网站的正则 */
	private String reg = "http.+";
	/** 存储网站的集合 */
	String[] strs = null;

	@SuppressWarnings("unused")
	@Test
	public void before() throws IOException {

		System.out.println("粘贴你要打开网站的文本，输入-1结束");
		String s = null;
		while (!"-1".equalsIgnoreCase(s = sr.next())) {
			content.append(s + "\r\n");
		}
		strs = RegTool.getContent(content.toString(), reg);
		System.out.println("你打开了"+strs.length+"个网站");
//		for (String _s : strs) {
//			Desktop.getDesktop().browse(URI.create(_s));
//		}
	}
}
