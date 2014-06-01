package com.xl.base;

/*
需求:在本程序中出书是-1,也是错误的是无法进行运算的.
那么就需要对这个问题进行自定义的描述

当在函数内部出现了throw抛出了异常对象,就必须要给对应的处理动作
要么在内部try catch处理.
要么在函数上声明让调用者处理.

一般情况下,函数内出现异常,函数上需要声明,
因为父类中已经把异常信息的操作完成了.\
所以子类只要在构造时,将异常信息传递给父类通过super语句.
那么就可以通过直接getMessage方法获取自定义的异常信息.

自定义异常:
必须是自定义类继承Exception.

继承Exception原因
异常体系有一个特点,异常类和异常对象都被抛出 
他们都具有可抛性,这个可抛性是

 */

//自定义处理异常
class FuShuException extends Exception // 建立的目的是为了生成对象
{
	private int value;

	public int getValue() {
		return value;
	}

	/*
	 * private String msg; //定义异常信息,覆写 FuShuException(String msg) {
	 * this.msg=msg; } public String getMessage() { return msg; }
	 */
	FuShuException(String msg, int value) // 相当于上面的代码
	{
		super(msg);
		this.value = value;
	}

}

class DemoTest {
	int div(int a, int b) throws FuShuException {
		if (b < 0) // 如果小于0就让程序停止运转
			throw new FuShuException("出现了除数是负数的情况", b); // 手动通过throw关键字抛出异常对象
		return a / b;
	}
}

class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			DemoTest d = new DemoTest();
			int x = d.div(4, -1);
			System.out.println("x=" + x);
		} catch (FuShuException e) {
			System.out.println(e.toString());
			System.out.println("错误的除数是" + e.getValue());
		}
	}
}
