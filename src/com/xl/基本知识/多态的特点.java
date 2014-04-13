package com.xl.基本知识;

//在多态中（父类指向子类对象）成员函数的特点：
//在编译时期：参阅引用型变量所属的类中中是否有调用的方法，如果有，编译通过，如果没有编译失败。
//在运行时期：参阅对象所属的类中是否有调用的方法
//总结：成员函数在多态调用时，编译看左边，运行看右边。

class Fu {
	int num = 5;

	void method1() {
		System.out.println("Fu_1");
	}

	void method2() {
		System.out.println("fu_2");
	}

}

class Zi extends Fu {
	int num = 8;

	void method1() {
		System.out.println("zi_1");
	}

	void method3() {
		System.out.println("zi_3");
	}
}

class DuoDemo {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.method1();
		f.method2();
		// f.method3(); //编译时这行出错
		System.out.print(f.num);

	}
}
