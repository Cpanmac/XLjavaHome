package com.xl.����;
import java.util.LinkedList;

class LinkedListDemo 
{
	public static void main(String[] args) 
	{
		LinkedList link = new LinkedList();
		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");
		link.addFirst("java05");
		link.addFirst("java06");
		sop(link.getFirst());
		sop(link.getLast());
		//���õ������������Ԫ��
	
			sop(link.toArray());
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

/*




*/