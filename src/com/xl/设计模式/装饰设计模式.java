package com.xl.设计模式;

//装饰设计模式：
//当想要对已有的对象进行功能增强时，可以定义类，将已有的对象传入，基于已有的功能，并提供加强功能。那么自定义的该类成为装饰类。
public class 装饰设计模式 {
	public static void main(String[] args) {
		Person p = new Person();
		// p.chifan(); 就不用老的吃饭方法了
		SuperPerson sp = new SuperPerson(p);
		sp.superChifan();
	}
}

class SuperPerson { // 对人类进行装饰
	private Person p;

	SuperPerson(Person p) { // 增强别人而存在
	}

	public void superChifan() { // 提高super吃饭
		System.out.println("开胃酒");
		System.out.println("吃饭");
		System.out.println("甜点	");
	}
}

class Person {
	public void chifan() {
		System.out.println("吃饭");
	}
}