package com.xl.base;

/*
��̬���������Ϊ������ڵĶ�����̬��

�ˣ����ˣ�Ů��

���è������

è x = new è������

���� x = new è������

��̬������ã�
1.��̬�Ļ�������
	���������ָ�����Լ����������
	���������Ҳ���Խ����Լ����������

2.��̬��ǰ��
	������������֮���й�ϵ��Ҫô�̳У�Ҫôʵ��
3.��̬�ĺô���
	��̬�ĳ��ִ����߳������չ�ԡ�
��̬�ı׶�
	�������չ�ԣ�����ֻ��ʹ�ø�������÷��ʸ���ĳ�Ա��
5.��̬��Ӧ��

ע�⣺ǧ���ܳ��������Ĳ��������ǽ��������ת���������͡�
//������ת���ĸ���Ӧ��ָ�����Լ����������ʱ����Ӧ�ÿ��Ա�������
��̬ʼ�ն���������������ű仯
Animal a=new Animal();
Cta c=(Cat)a;

���
è������
*/



abstract class Animal
{
	public abstract void eat();   //��ȷ��     
}


class Cat extends Animal
{
	public void eat()
	{
		System.out.println("����");
	}
	public void catchMouse()
	{
		System.out.println("ץ����");
	}

}

class Dog extends Animal
{
	public void eat()
	{
		System.out.println("�Թ�ͷ");
	}
	public void kanjia()
	{
		System.out.println("����");
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
		Animal a=new Cat();                 //��������������ת��
		function(new Cat());   
		Cat c=(Cat)a;	 //ǿ�ƽ���������ã�ת�����������͡�  ����ת��
		c.catchMouse();
	} 
	public static void function(Animal a)   //��Ϊ�����ж������"�ԡ����Գ�ȡ���ܣ���ߴ���ĸ�����javascript:;
	{
		a.eat();
		if(a instanceof Cat)             //�ж�a�Ƿ���è����
		{
			Cat c=(Cat)a;		
			c.catchMouse();
		}
	}

/*	public static void function(Dog d)    //������  ����Ĺ��ܰ�����
	{
		d.eat();
	}
*/
}