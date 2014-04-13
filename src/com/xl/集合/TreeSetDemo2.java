package com.xl.集合;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Student3 implements Comparable // 强制让学生具备比较性。
{
	private String name;
	private int age;

	Student3(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int compareTo(Object obj) // 覆盖方法不能声明异常
	{
		if (!(obj instanceof Student3))
			throw new RuntimeException("不是学生对象");
		Student3 s = (Student3) obj;
		if (this.age < s.age)
			return 1; // 返回是正数就行。
		if (this.age == s.age)
			// return 0; //换成这更好 return this.name.compareTo(s.name);
			return this.name.compareTo(s.name);
		return age; // 这要换成age
	}
}

public class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(); // TreeSet ts = new TreeSet(new
									// MyCompare());
		ts.add(new Student3("lisi02", 22));
		ts.add(new Student3("lisi007", 20));
		ts.add(new Student3("lisi09", 19));
		ts.add(new Student3("lisi06", 19));
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Student3 stu = (Student3) it.next(); // 如果想打印对象的话
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

class MyCompare implements Comparator // 按姓名排序上面代码就改变个return sge;
{
	public int compare(Object o1, Object o2) // 这里面是compare方法
	{
		Student3 s1 = (Student3) o1;
		Student3 s2 = (Student3) o2;
		// return s1.getName().compareTo(s2.getName());
		// //按姓名排序，一旦姓名相同就无法添加相同的元素了
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
			// return s1.getAge()-s2.getAge(); //可以相减！ 还有方法，因为数字可以排序 把整数转化成对象
			return new Integer(s1.getAge()).compareTo(s2.getAge());

		return num;
	}
}
