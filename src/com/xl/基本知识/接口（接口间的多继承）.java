package com.xl.����֪ʶ;

/*
 �ӿڣ����ڵ���⣬������Ϊ��һ������ĳ�����
 ���������еķ������ǳ���ģ���ô�������ͨ���ӿڵ���ʽ����ʾ��
 class���ڶ�����
 interface ���ڶ���ӿ�

 �ӿڶ���ʱ����ʽ�ص㣺
 1.�ӿ��г������壺���������󷽷���
 2.�ӿ��еĳ�Ա���й̶����η���   ������ʡ���ˣ�ϵͳ���Զ����ϣ�
 ������pubilc static final
 ������public abstract
 �ӿ��еĳ�Ա����public��
 �ӿڲ����Դ���������Ϊ�г��󷽷���
 ��Ҫ������ʵ�֣�����Խӿ��еĳ��󷽷�ȫ�����Ǻ�����ſ���ʵ������
 ����������һ��������
 java�ж�̳У�ֻ�нӿ���ӿ�֮����ڶ�̳У�������û
 */

interface Inter {
	public static final int NUM = 3;

	public abstract void show();
}

class Test implements Inter // ������м̳У� ���ʵ�ֹ�ϵ
{
	public void show() {
	}
}

interface A {
	void methodA();
}

interface B {
	void methodB();
}

interface C extends B, A // ��̳�
{
	void methodC();
}

class InterfaceDemo {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.NUM);
		System.out.println(Test.NUM);
		System.out.println(Inter.NUM);
	}
}
