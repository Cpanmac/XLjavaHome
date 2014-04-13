package com.xl.网络编程;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class URL编码解码 {
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws UnsupportedEncodingException {
		String s = "dse中国sdf";
		String _s = URLEncoder.encode(s);
		System.out.println(_s);
		_s = URLEncoder.encode(s, "UTF-8");
		System.out.println(_s);
		_s=URLEncoder.encode(s,"GBK");
		System.out.println(_s);
		s = URLDecoder.decode(s);
		System.out.println(s);
	}
}
