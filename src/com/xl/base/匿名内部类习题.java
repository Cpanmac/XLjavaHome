package com.xl.base;

interface Inter1 {
	void method();
}

class Test1 {
	// �������
	static Inter1 function() {
		return new Inter1() {
			public void method() {
				System.out.println("method run");
			}
		};
	}

}

class InnerClassTest {
	public static void main(String[] args) {
		Test1.function().method(); // ��������. ��֪��Test�Ǿ�̬�ģ������б��ǿղ���,method�ǳ����
									// ֻ�з������Ǹ�������ܱ����ã�����method��Ȼ��Tnter�Ķ���Inter���ܵ�������ֻ����������
	}
}

/*
 * ��һ�� { static class Inner implements Inter { public void method() {
 * System.out.println("method run"); } }
 * 
 * static Inter function() { return new Inner(); } }
 */