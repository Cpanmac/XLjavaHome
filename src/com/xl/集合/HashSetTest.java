package com.xl.����;
/*
��hashSet�����д����Զ�����
������������ͬΪ ͬһ���ˣ��ظ�Ԫ��
 */
import java.util.HashSet;
import java.util.Iterator;

class HashSetTest {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new Person("a1", 11));
		hs.add(new Person("a2", 12));
		hs.add(new Person("a3", 13));
		hs.add(new Person("a2", 12));
		sop("a1:" + hs.contains(new Person("a1", 11)));
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			Person p = (Person) it.next();
			sop(p.getName() + "::" + p.getAge());
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}

