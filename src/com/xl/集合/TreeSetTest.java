package com.xl.����;
/*
��Ϊ�Լ������бȽϣ�����ֻ���ñȽ�����
*/
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
class TreeSetTest 
{
	public static void main(String[] args) 
	{
		/*
		TreeSet ts = new TreeSet(new StrLenCompare()  //��Ϊֻ��һ������
		{
				String a1 = (String)o1;
		String a2 = (String)o2;
		int num =new Integer(a1.length()).compareTo(a2.length());  //Integer����compare����
		if(num==0)
			return a1.compareTo(a2);        //�����ͬ����,�Ͱ��Զ���ıȽ�
		return	num;		
		}		
		);
		*/		
		
		TreeSet ts = new TreeSet(new StrLenCompare());	//�����Կ��Ըĳ������ڲ���
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
		Ҳ������
		String a1 = (String)o1;
		String a2 = (String)o2;
		if (a1.length()>a2.length())
		return 1;
		else		
		return -1;
		*/
		String a1 = (String)o1;
		String a2 = (String)o2;
		int num =new Integer(a1.length()).compareTo(a2.length());  //Integer����compare����
		if(num==0)
			return a1.compareTo(a2);        //�����ͬ����,�Ͱ��Զ���ıȽ�
		return	num;
	}	
}
