package com.xl.基本知识;

/*
 abstract class Student  //学习不确定
 {
 abstract void study();
 void sleep()
 {
 System.out.println("sleep");
 }

 }

 interface Smoking     //作为一个功能扩展出来需要就用，不需要就不用
 {
 void smoke();

 }

 class ZhangSan extends Student implements Smoking       //张三像个烟民不是烟民   接口是like就是像其中的一个  
 {
 void study(){}
 public void smoke(){}
 }
 */

abstract class Sporter {
	abstract void play(); // 基本功能定义在类中，扩展功能定义在接口中 找到组织了是继承。 比如：公务员开了一小卖店
							// 体系外用接口体现
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
