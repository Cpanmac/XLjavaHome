package com.xl.����֪ʶ;

/*
��̬��Ӧ��
������ѧ����
	ѧϰ��˯����
	�߼���ѧ��
		ѧϰ��˯����
*/

abstract class Student
{
	public abstract void study();
	public void sleep()
	{
		System.out.println("����˯");
	}

}

class BaseStudent extends Student
{
	public void study()
	{
		System.out.println("base study");
	}

}

class DoStudent       //�����࣬�Ժ���������������
{	
	public void dosome(Student stu)              //��˭����˭����
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
