package com.xl.base;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Test;

public class MD5Demo {
	/** ����֮ǰ */
	String before = "12sd%fa31231";
	/** ����֮�� */
	String after;
	
	@Test
	public void MD5����() {
		after = DigestUtils.md5Hex(before);
		// �����ַ�������
		System.out.println("���ַ���:" + DigestUtils.md5Hex(""));
	}
	
	@Test
	public void MD5() {
		after = com.xl.util.MD5.toMD5(before); // E4FD61E22724C6212E791B945C78F2D5
	}
	
	@After
	public void ���() {
		System.out.println("λ��:" + before.length() + ",����֮ǰ:" + before);
		System.out.println("λ��:" + after.length() + ",����֮��:" + after + "");
	}
	
	
}
