package com.xl.base;

interface Inter1 {
	void method();
}

class Test1 {
	// 补足代码
	static Inter1 function() {
		return new Inter1() {
			public void method() {
				System.out.println("method run");
			}
		};
	}

}

class InnerClassTest {
	public static void main(String[] args) {
		Test1.function().method(); // 看到类名. 就知道Test是静态的，参数列表是空参数,method是抽象的
									// 只有返回来是个对象才能被调用，调用method必然是Tnter的对象，Inter不能调用所以只能是其子类
	}
}

/*
 * 答案一： { static class Inner implements Inter { public void method() {
 * System.out.println("method run"); } }
 * 
 * static Inter function() { return new Inner(); } }
 */