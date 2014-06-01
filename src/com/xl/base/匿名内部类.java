package com.xl.base;

/*
内部类的访问规则：
1.内部类可以直接访问外部类中的成员，包括私有。 (之所以可以直接访问外部类中的成员。是因为内部类中持有了一个外部类的引用，格式 外部类名.this
2.外部类要访问内部类，必须建立内部类的对象
访问格式：
当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。
可以直接建立内部类对象。
格式
	外部类.内部类  对象名=new 外部类对象.内部类对象
	Outer.Inner in=new Outer().new Inner();

2.当内部类在成员位置上，就可以被成员修饰符所修饰。   （了解）
	比如:private:将内部类在外部类中进行封装
		static:内部类就具有static的特性。
		当内部类被static修饰后，只能直接访问外部类中的static成员。出现了访问的局限
		
		在外部其他类中，如何直接访问static内部类的非静态成员呢？
		new Outer.Inner().function();

		在外部其他类中，如何直接访问static内部类的静态成员呢？
		oter.Inner.function();

		注意当内部类中定义了静态成员，该内部类必须是静态的
			当外部类中的静态方法访问内部类时，内部类也必须是static

当描述事物时，事物的内部还有内部事物，该事物用内部类来描述。
因为内部事物在使用外部事物的内容。
内部类定义在局部时：
1.不可以被成员修饰符修饰
2.可以直接访问外部类中的成员，因为还持有外部类中的引用。
	但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量
*/
abstract class AbsDemo
{
	abstract void show();
}
class Outer
{


	int x=3;



  	/*             可以改成匿名内部类
	class Inner extends AbsDemo
		{
			void show()
			{
				System.out.println("method:"+x);           //Outer.this 可以省略
				
			}
			
		}
  */
	public void function()
	{
	//		new Inner().show();

		new AbsDemo()
		{
			
			void show()
			{
				System.out.println("x="+x);
			}
			                //要写在Inner的后面 写前面不行
		}.show();
	}
	
}

class Xl
{
	public static void main(String[] args)
	{
		new Outer().function();
		
	}
}




















/*
class Outer
{
	private static int x=3;
	static class Inner   //静态内部类   全是共享数据就是静态    在加载Outer时，静态就直接被加载
	{
		static void function()
		{
			System.out.println("innter:"+x);
		}
	}
	class Inner2
	{
		void show()
		{
			System.out.println("innter2 shou");
		}
	}
	
	public static void method()
	{
		Inner.function();
	}
}

class InnerClassDemo2
{
	 public static void main(String[] args)
	{
		//new Outer.Inner().function();
		Outer.method();



	}
}
*/