package com.xl.����;

interface Inter<T> // ����ӿ�ֻ���������
{
	void show(T t);
}

/*
 * class InterImpl implements Inter<String> //�ӿ�ʵ���࣬��String�����������ȥ�ˣ�ֻ�ܽ���String {
 * public void show(String t) { System.out.println("show:"+t); } }
 */

class InterImpl<T> implements Inter<T> {
	public void show(T t) {
		System.out.println("show��" + t);
	}
}

class GenericDemo5 {
	public static void main(String[] args) {
		// InterImpl i = new InterImpl();
		InterImpl<Integer> i = new InterImpl<Integer>();
		i.show(4);
	}
}
