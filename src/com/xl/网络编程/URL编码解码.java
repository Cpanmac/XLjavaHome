package com.xl.������;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class URL������� {
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws UnsupportedEncodingException {
		String s = "dse�й�sdf";
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
