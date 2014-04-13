package com.xl.集合;

/*
 去除ArrayList集合中的重复元素。
 思路：
 1.创立一个新的容器。
 2.将原容器一个个往里存，如果相同就去掉
 */
import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("java01");
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java02");
		a1.add("java04");
		System.out.println(a1);
		a1 = singleElement(a1); // 可以用自己接受
		System.out.println(a1);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList singleElement(ArrayList a1) {
		// 定义一个容器
		ArrayList newA1 = new ArrayList();
		Iterator it = a1.iterator();
		while (it.hasNext()) {
			Object obj = it.next(); // 拿一个元素用Object记下
			if (!newA1.contains(obj)) // 如果新容器没用，就往里存
			{
				newA1.add(obj);
			}
		}

		return newA1;
	}
}
/*
 * 注意：如果是以下代码 当容器中元素是偶数的时候不会出错，如果是奇数就会出异常，因为一次取两个
 * 
 * while(it.hasNext()) { System.out.print(it.next()+"..."+it.next()); }
 */