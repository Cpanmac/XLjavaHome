package com.xl.����;

/*
 ȥ��ArrayList�����е��ظ�Ԫ�ء�
 ˼·��
 1.����һ���µ�������
 2.��ԭ����һ��������棬�����ͬ��ȥ��
 */
import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("java01");
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java02");
		a1.add("java04");
		System.out.println(a1);
		a1 = singleElement(a1); // �������Լ�����
		System.out.println(a1);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList singleElement(ArrayList a1) {
		// ����һ������
		ArrayList newA1 = new ArrayList();
		Iterator it = a1.iterator();
		while (it.hasNext()) {
			Object obj = it.next(); // ��һ��Ԫ����Object����
			if (!newA1.contains(obj)) // ���������û�ã��������
			{
				newA1.add(obj);
			}
		}

		return newA1;
	}
}
/*
 * ע�⣺��������´��� ��������Ԫ����ż����ʱ�򲻻��������������ͻ���쳣����Ϊһ��ȡ����
 * 
 * while(it.hasNext()) { System.out.print(it.next()+"..."+it.next()); }
 */