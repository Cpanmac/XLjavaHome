package com.xl.泛型;

interface Inter<T> // 这个接口只定义个参数
{
	void show(T t);
}

/*
 * class InterImpl implements Inter<String> //接口实现类，把String这个参数传进去了，只能接收String {
 * public void show(String t) { System.out.println("show:"+t); } }
 */

class InterImpl<T> implements Inter<T> {
	public void show(T t) {
		System.out.println("show：" + t);
	}
}

class GenericDemo5 {
	public static void main(String[] args) {
		// InterImpl i = new InterImpl();
		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(4);
	}
}
