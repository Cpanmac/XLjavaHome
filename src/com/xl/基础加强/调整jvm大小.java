package com.xl.基础加强;

public class 调整jvm大小 {
	public static void main(String[] args) {
		// 1024*1024是1M.
		byte[] b = new byte[1024 * 1024 * 65];
		// jvm默认占64M内存,超过了会出异常,查看原版的java150jdk文档
//		在run as-->run configurantions-->Arguments,下面的VM Arguments:  -Xmx80m 改成了80m
	}
}
