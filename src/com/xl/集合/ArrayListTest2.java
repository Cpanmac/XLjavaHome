package com.xl.集合;
/*
将自定义对象作为元素存到ArrayList集合中，并去除重复元素。 (判断对象是否相同用equals)
比如：村人存对象。同姓名同年龄，视为同一个人，为重复元素。
思路：
1.对人描述，将数据封装进入人对象
2.定义容器，将人存入        
3.取出
List集合判断元素是否相同，依据是元素的equals方法。
contains和remove都是用了equals，数据结构不同方法不同
 */
import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add(new Person("李四", 30));
		a1.add(new Person("李四2", 33));
		a1.add(new Person("李四2", 33));

		// System.out.println(a1); //打印出来的都是地址
		// Iterator it = a1.iterator();
		/*
		 * while (it.hasNext()) { Object obj; obj = it.next(); Person p =
		 * (Person)obj; System.out.print(p.getName()+"..."+p.getAge()); }
		 */
		a1.remove(0);
		System.out.println(a1);

	}

	public static ArrayList singleElement(ArrayList a1) // 传入一个数组，删除相同的元素
	{
		ArrayList newA1 = new ArrayList();
		Iterator it = a1.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (!(newA1.contains(obj)))
				newA1.add(obj);
		}
		return newA1;

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}

