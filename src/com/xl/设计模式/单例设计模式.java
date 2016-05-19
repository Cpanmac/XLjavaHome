package com.xl.设计模式;

/*
设计模式：解决问题的最有效的方法
java中23种设计模式：
单例设计模式：解决一个类在内存中只存在一个对象.

想要保证对象唯一。
1.为了避免其他程序建立对象，先禁止其他程序建立该类对象
2.还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。
3.为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。

这三部怎么用代码体现
1.将构造函数私有化。
2.在本类中创建一个本类对象。
3.提供一个方法可以获取到该对象

对于事物怎么描述，还怎么描述。
当需要该事物的对象保证在内存中唯一时，就将以上的三部加上即可

*/

class Single {
    private static Single s = new Single();                    //成员变量，私有化一下

    private Single() {
    }

    public static Single getInstance()   //   //Instance  实例   为了使其能类名调用所以前面+静态static
    {
        return s;
    }
}

class SingleDemo {
    public static void main(String[] args) {
        Single ss = Single.getInstance();
        Single s1 = Single.getInstance();           //这两个都是指向同一个类，因为不能被建立
    }
}

class Student {
    private String name;
    private int age;
}

/*	private 类名(){}
    private static 类名 变量名=new 类名();
	pubilc static 类名 函数名()
	{
		return 变量名;
	}*/