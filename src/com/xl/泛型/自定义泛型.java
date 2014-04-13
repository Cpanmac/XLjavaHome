package com.xl.泛型;


public class 自定义泛型 {
	public void test() {

	}

	public <T> T a(T t) {
		return null;
	}
	
	//先声明T再使用,多个单个都可以
	public <T,E,K> void b(T t,E e,K k){
		
	}
	//静态得泛型
	public static <T> void c(T t){
		
	}
}
