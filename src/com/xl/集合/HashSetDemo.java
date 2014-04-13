package com.xl.集合;
/*
set接口:元素是无序的//存入和取出的顺序是不一定一致，元素不可以重复，并且最多包含一个null元素
set集合的功能和Collection是一样的，没有角标
常见子类
HashSet:底层数据结构是哈希表。 
TreeSet:
哈希表：存放一堆哈希值(二进制)的表，存放的哈希值就是对象地址值,每个对象都有hashCode方法，可以覆写掉
*/
import java.util.HashSet;
import java.util.Iterator;
class HashSetDemo
{
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();
		hs.add("java01");             //返回值是布尔型,所以无法存储相同的元素。
		hs.add("java01");
		hs.add("java03");
		hs.add("java03");
		hs.add("java02");
		sop(hs.add("java01"));
		Iterator it = hs.iterator();      //取出HashSet
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
	public int hashCode()   //复写掉win的值
	{
	return 1;
	}
}