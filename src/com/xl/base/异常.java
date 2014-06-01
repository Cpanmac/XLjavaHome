package com.xl.base;

/*
有一个圆形和长方形。
都可以获取面积。对面面积如果出现非法的数值。视为是获取面积出现的问题
问题通过异常表示。
现有对这个程序进行基本设计

*/
class  NoValueException extends Exception
{
	public NoValueException(String message)
	{
		super(message);
	}

}




interface Shape                 //求面积作为一个扩展功能，Shape 这个类java本身有所以是红色
{
	void getArea();            //没有参数。长和宽是固定的，无法抽取，只需要获取
}


class Rec implements Shape
{ 
	private int len,wid;                                    
	Rec(int len,int wid)throws NoValueException
	{
		if(len<=0 || wid<=0)                        //问题处理代码
	//		System.out.println("错了");        
		throw new NoValueException("出现非法");
	//	else   不用else                                       //正常流程代码           他们结合的很紧密
		{
		this.len=len;
		this.wid=wid;
		}
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}


class ExceptionTest1
{
	public static void main(String[] args)
	{
		Rec r;
		try {
			r = new Rec(-3,4);
			r.getArea();
		} catch (NoValueException e) {
			e.printStackTrace();
		}
		
	}
}