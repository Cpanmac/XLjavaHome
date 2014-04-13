package com.xl.基本知识;

class StaticCod
{
	static
	{
		System.out.println("a");
	}
	public void show()
	{

	}
}

class Demo1
{
	static
	{
		System.out.println("b");
	}
	public static void main(String[] args)
	{
		new StaticCod();
		new StaticCod();
	}
	static
	{
		System.out.println("c");
	}
}
//结果是a  c  b 
