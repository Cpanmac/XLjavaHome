package com.xl.����;
import java.util.ArrayList;
import java.util.Iterator;

class GenericDemo
{
	public static void main(String[] args) 
	{
		ArrayList<String> a1 = new ArrayList<String>();  
		a1.add("abc01");
		a1.add("abc0991");
		a1.add("abc014");
	//	a1.add(new Integer(4));   ���ClassCastException�쳣������û���⣬�����쳣
		Iterator<String> it = a1.iterator();
		while (it.hasNext())
		{
			String s= it.next();
			System.out.println(s+":"+s.length());
		}
	}
}
