package com.xl.base;

/*
�ڲ���ķ��ʹ���
1.�ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�С� (֮���Կ���ֱ�ӷ����ⲿ���еĳ�Ա������Ϊ�ڲ����г�����һ���ⲿ������ã���ʽ �ⲿ����.this
2.�ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ���Ķ���
���ʸ�ʽ��
���ڲ��ඨ�����ⲿ��ĳ�Աλ���ϣ����ҷ�˽�У��������ⲿ�������С�
����ֱ�ӽ����ڲ������
��ʽ
	�ⲿ��.�ڲ���  ������=new �ⲿ�����.�ڲ������
	Outer.Inner in=new Outer().new Inner();

2.���ڲ����ڳ�Աλ���ϣ��Ϳ��Ա���Ա���η������Ρ�   ���˽⣩
	����:private:���ڲ������ⲿ���н��з�װ
		static:�ڲ���;���static�����ԡ�
		���ڲ��౻static���κ�ֻ��ֱ�ӷ����ⲿ���е�static��Ա�������˷��ʵľ���
		
		���ⲿ�������У����ֱ�ӷ���static�ڲ���ķǾ�̬��Ա�أ�
		new Outer.Inner().function();

		���ⲿ�������У����ֱ�ӷ���static�ڲ���ľ�̬��Ա�أ�
		oter.Inner.function();

		ע�⵱�ڲ����ж����˾�̬��Ա�����ڲ�������Ǿ�̬��
			���ⲿ���еľ�̬���������ڲ���ʱ���ڲ���Ҳ������static

����������ʱ��������ڲ������ڲ�������������ڲ�����������
��Ϊ�ڲ�������ʹ���ⲿ��������ݡ�
�ڲ��ඨ���ھֲ�ʱ��
1.�����Ա���Ա���η�����
2.����ֱ�ӷ����ⲿ���еĳ�Ա����Ϊ�������ⲿ���е����á�
	���ǲ����Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�����
*/
abstract class AbsDemo
{
	abstract void show();
}
class Outer
{


	int x=3;



  	/*             ���Ըĳ������ڲ���
	class Inner extends AbsDemo
		{
			void show()
			{
				System.out.println("method:"+x);           //Outer.this ����ʡ��
				
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
			                //Ҫд��Inner�ĺ��� дǰ�治��
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
	static class Inner   //��̬�ڲ���   ȫ�ǹ������ݾ��Ǿ�̬    �ڼ���Outerʱ����̬��ֱ�ӱ�����
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