package com.xl.����;
/*
set�ӿ�:Ԫ���������//�����ȡ����˳���ǲ�һ��һ�£�Ԫ�ز������ظ�������������һ��nullԪ��
set���ϵĹ��ܺ�Collection��һ���ģ�û�нǱ�
��������
HashSet:�ײ����ݽṹ�ǹ�ϣ�� 
TreeSet:
��ϣ�����һ�ѹ�ϣֵ(������)�ı���ŵĹ�ϣֵ���Ƕ����ֵַ,ÿ��������hashCode���������Ը�д��
*/
import java.util.HashSet;
import java.util.Iterator;
class HashSetDemo
{
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();
		hs.add("java01");             //����ֵ�ǲ�����,�����޷��洢��ͬ��Ԫ�ء�
		hs.add("java01");
		hs.add("java03");
		hs.add("java03");
		hs.add("java02");
		sop(hs.add("java01"));
		Iterator it = hs.iterator();      //ȡ��HashSet
		while (it.hasNext())
		{
			sop(it.next());
		}
	}
	public static void sop(Object obj)
	{
	System.out.println(obj);
	}
}
class Demo
{
	public int hashCode()   //��д��win��ֵ
	{
	return 1;
	}
}