package com.xl.base;

/*
多态：可以理解为事物存在的多种形态。

人：男人，女人

动物：猫，狗。

猫 x = new 猫（）；

动物 x = new 猫（）；

多态如何运用：
1.多态的基本体现
	父类的引用指向了自己的子类对象
	父类的引用也可以接受自己的子类对象

2.多态的前提
	必须是类与类之间有关系，要么继承，要么实现
3.多态的好处：
	多态的出现大大提高程序的扩展性。
多态的弊端
	提高了扩展性：但是只能使用父类的引用访问父类的成员。
5.多态的应用

注意：千万不能出现这样的操作：就是将父类对象转成子类类型。
//我们能转化的父类应用指向了自己的子类对象时，该应用可以被提升，
多态始终都是子类对象再做着变化
Animal a=new Animal();
Cta c=(Cat)a;

动物：
猫，狗。
*/



abstract class Animal
{
	public abstract void eat();   //不确定     
}


class Cat extends Animal
{
	public void eat()
	{
		System.out.println("吃鱼");
	}
	public void catchMouse()
	{
		System.out.println("抓老鼠");
	}

}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("吃骨头");
	}
	public void kanjia()
	{
		System.out.println("看家");
	}
}







class DuoTaiDemo
{
	public static void main(String[] args)
	{
	  /*  Cat c = new Cat();
		c.eat();
		
		Dog d = new Dog();
		d.eat();
		*/
		Animal a=new Cat();                 //类型提升。向上转型
		function(new Cat());   
		Cat c=(Cat)a;	 //强制将父类的引用，转化成子类类型。  向下转型
		c.catchMouse();
	} 
	public static void function(Animal a)   //因为可能有多个对象"吃”所以抽取功能，提高代码的复用性javascript:;
	{
		a.eat();
		if(a instanceof Cat)             //判断a是否是猫类型
		{
			Cat c=(Cat)a;		
			c.catchMouse();
		}
	}

/*	public static void function(Dog d)    //单独的  上面的功能包括了
	{
		d.eat();
	}
*/
}