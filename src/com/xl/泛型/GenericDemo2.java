package com.xl.泛型;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
class GenericDemo2 
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts =new TreeSet<String>(new LenComparator());
		ts.add("abc");
		ts.add("wejri");
		ts.add("sqawiqd");
		ts.add("as");
		ts.add("bs");
		Iterator<String> it = ts.iterator();
		while(it.hasNext())
		{
			String s=it.next();
			System.out.println(s);			
		}		
	}
}
class LenComparator implements Comparator<String>  //这加了<String?
{
	public int compare(String o1,String o2)  //这儿就不写Object 写String
	{
	 	int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));
		if (num==0)
		return o1.compareTo(o2);
		else
			return num;
	}
}