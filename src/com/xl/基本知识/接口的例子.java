package com.xl.����֪ʶ;

/*
 abstract class Student  //ѧϰ��ȷ��
 {
 abstract void study();
 void sleep()
 {
 System.out.println("sleep");
 }

 }

 interface Smoking     //��Ϊһ��������չ������Ҫ���ã�����Ҫ�Ͳ���
 {
 void smoke();

 }

 class ZhangSan extends Student implements Smoking       //�����������������   �ӿ���like���������е�һ��  
 {
 void study(){}
 public void smoke(){}
 }
 */

abstract class Sporter {
	abstract void play(); // �������ܶ��������У���չ���ܶ����ڽӿ��� �ҵ���֯���Ǽ̳С� ���磺����Ա����һС����
							// ��ϵ���ýӿ�����
}

interface Study {
}

class Wangwu extends Sporter implements Study {

	@Override
	void play() {

	}
}

class StudentDemo {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
