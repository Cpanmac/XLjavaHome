package com.xl.����;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Student3 implements Comparable // ǿ����ѧ���߱��Ƚ��ԡ�
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

	public int compareTo(Object obj) // ���Ƿ������������쳣
	{
		if (!(obj instanceof Student3))
			throw new RuntimeException("����ѧ������");
		Student3 s = (Student3) obj;
		if (this.age < s.age)
			return 1; // �������������С�
		if (this.age == s.age)
			// return 0; //��������� return this.name.compareTo(s.name);
			return this.name.compareTo(s.name);
		return age; // ��Ҫ����age
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
			Student3 stu = (Student3) it.next(); // ������ӡ����Ļ�
			System.out.println(stu.getName() + "..." + stu.getAge());
		}
	}
}

class MyCompare implements Comparator // �����������������͸ı��return sge;
{
	public int compare(Object o1, Object o2) // ��������compare����
	{
		Student3 s1 = (Student3) o1;
		Student3 s2 = (Student3) o2;
		// return s1.getName().compareTo(s2.getName());
		// //����������һ��������ͬ���޷������ͬ��Ԫ����
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
			// return s1.getAge()-s2.getAge(); //��������� ���з�������Ϊ���ֿ������� ������ת���ɶ���
			return new Integer(s1.getAge()).compareTo(s2.getAge());

		return num;
	}
}
