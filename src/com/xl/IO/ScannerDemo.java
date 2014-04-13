package com.xl.IO;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

import com.xl.util.NetUtil;

public class ScannerDemo {
	@Test
	public void ¶ÁÈ¡Á÷() {
		String content = NetUtil.getContent("http://www.hao123.com");
		Scanner sr = new Scanner(content);
		String s;
		Pattern p=Pattern.compile(".+");
		while ((s = sr.findInLine(p)) != null) {
			System.out.println(s);
		}
	}
}
