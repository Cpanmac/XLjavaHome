package com.xl.base;

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
//½á¹ûÊÇa  c  b 
