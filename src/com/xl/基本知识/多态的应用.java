package com.xl.基本知识;

/*
多态的应用
基础班学生：
	学习，睡觉。
	高级班学生
		学习，睡觉。
*/

abstract class Student
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("躺着睡");
	}

}

class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}

}

class DoStudent       //工具类，以后主函数找它就行
{	
	public void dosome(Student stu)              //传谁进来谁运行
	{
		stu.study();
		stu.sleep();
	}
}



class AdvStudent extends Student
{
	public void study()
	{
		System.out.println("adv study");
	}
}





class DuoDemo1 
{
	public static void main(String[] args)
	{
		DoStudent ds = new DoStudent();      
		ds.dosome(new BaseStudent());
		ds.dosome(new AdvStudent());
		BaseStudent bs=new BaseStudent();
	}
}
