package com.xl.基本知识;

/**
构造函数对象一建立就会调用与之对应的构造函数。
作用：可以用于给对象进行初始化
构造函数小细节
当一个类中没有定义构造函数时，那么系统会默认给该类加入一个空参数的构造函数
当在类中自定义了构造函数后，默认的构造函数就没有了
构造函数和一般函数在写法上有不同。
在运行商业有不同。
构造函数时在对象一建立就运行。给对象初始化。
而一般方法是对象调用才执行，给是对象添加对象具备的功能。

一个对象建立，构造函数只运行一次。
而一般方法可以被该对象调用多次
什么时候定义构造函数呢？
当分析事物时，该事物存在具备一些特性或者行为，那么将这些内容定义在构造函数中。
特点：this代表其所在函数所属对象的引用。
换言之：this代本类对象的引用。

什么时候使用this关键字呢？
当在函数内需要用到调用该函数的对象时，就用this。
例程。
this 看上去是用于区别局部变量和成员变量同名的情况  代表本类的对象
this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，这是用this来表示这个对象。
	但凡本类功能内部使用了本类对象都用到了this

*/
class Person       //此类中有3个构造函数，一个类可以产生N个类
{
	private String name;
	private int age;
	/*
	构造代码块
	作用：给对象进行初始化。
	对象一建立就运行，而且优先于构造函数执行。
	和构造函数的区别：
	构造代码块是给所有对象进行统一初始化
	而构造函数时给对应的对象初始化
	*/
	{
		System.out.println("person code run");
	}

	Person()
	{
		System.out.println("A:name="+name+",,age="+age);
	}
	Person(String n)
	{
		name =n;
		System.out.println("B:name="+name+",age="+age);
	}
	Person(String n,int a)
	{
		name =n;
		age =a;
		System.out.println("C:name="+name+",,age="+age);
	}
	public void setName(String n)
	{
		name = n;
	}

}




/*
//默认的构造函数
class Person
{
								//其中省略了Person(){}
}
*/