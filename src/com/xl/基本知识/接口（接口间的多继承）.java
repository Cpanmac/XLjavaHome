package com.xl.基本知识;

/*
 接口：初期的理解，可以认为是一个特殊的抽象类
 当抽象类中的方法都是抽象的，那么该类可以通过接口的形式来表示。
 class用于定义类
 interface 用于定义接口

 接口定义时，格式特点：
 1.接口中常见定义：常量，抽象方法。
 2.接口中的成员都有固定修饰符。   （所以省略了，系统会自动加上）
 常量：pubilc static final
 方法：public abstract
 接口中的成员都是public的
 接口不可以创建对象，因为有抽象方法。
 需要被子类实现，子类对接口中的抽象方法全部覆盖后，子类才可以实例化。
 否则子类是一个抽象类
 java有多继承，只有接口与接口之间存在多继承，其他都没
 */

interface Inter {
	public static final int NUM = 3;

	public abstract void show();
}

class Test implements Inter // 类与类叫继承， 这叫实现关系
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

interface C extends B, A // 多继承
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
