package com.xl.集合;
/*
因为自己本身有比较，所以只能用比较器。
*/
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
class TreeSetTest 
{
	public static void main(String[] args) 
	{
		/*
		TreeSet ts = new TreeSet(new StrLenCompare()  //因为只有一个方法
		{
				String a1 = (String)o1;
		String a2 = (String)o2;
		int num =new Integer(a1.length()).compareTo(a2.length());  //Integer中有compare方法
		if(num==0)
			return a1.compareTo(a2);        //如果相同长度,就按自定义的比较
		return	num;		
		}		
		);
		*/		
		
		TreeSet ts = new TreeSet(new StrLenCompare());	//还可以可以改成匿名内部类
		ts.add("abc");
		ts.add("wejri");
		ts.add("sqawiqd");
		ts.add("as");
		ts.add("bs");
		Iterator it = ts.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}

	}
}

class StrLenCompare implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		/*
		也可以用
		String a1 = (String)o1;
		String a2 = (String)o2;
		if (a1.length()>a2.length())
		return 1;
		else		
		return -1;
		*/
		String a1 = (String)o1;
		String a2 = (String)o2;
		int num =new Integer(a1.length()).compareTo(a2.length());  //Integer中有compare方法
		if(num==0)
			return a1.compareTo(a2);        //如果相同长度,就按自定义的比较
		return	num;
	}	
}
