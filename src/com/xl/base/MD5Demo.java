package com.xl.base;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Test;

public class MD5Demo {
	/** 加密之前 */
	String before = "12sd%fa31231";
	/** 加密之后 */
	String after;
	
	@Test
	public void MD5加密() {
		after = DigestUtils.md5Hex(before);
		// 给空字符串加密
		System.out.println("空字符串:" + DigestUtils.md5Hex(""));
	}
	
	@Test
	public void MD5() {
		after = com.xl.util.MD5.toMD5(before); // E4FD61E22724C6212E791B945C78F2D5
	}
	
	@After
	public void 输出() {
		System.out.println("位数:" + before.length() + ",加密之前:" + before);
		System.out.println("位数:" + after.length() + ",加密之后:" + after + "");
	}
	
	
}
