package com.xl.����;
/*
���Զ��������ΪԪ�ش浽ArrayList�����У���ȥ���ظ�Ԫ�ء� (�ж϶����Ƿ���ͬ��equals)
���磺���˴����ͬ����ͬ���䣬��Ϊͬһ���ˣ�Ϊ�ظ�Ԫ�ء�
˼·��
1.���������������ݷ�װ�����˶���
2.�������������˴���        
3.ȡ��
List�����ж�Ԫ���Ƿ���ͬ��������Ԫ�ص�equals������
contains��remove��������equals�����ݽṹ��ͬ������ͬ
 */
import java.util.ArrayList;
import java.util.Iterator;

class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add(new Person("����", 30));
		a1.add(new Person("����2", 33));
		a1.add(new Person("����2", 33));

		// System.out.println(a1); //��ӡ�����Ķ��ǵ�ַ
		// Iterator it = a1.iterator();
		/*
		 * while (it.hasNext()) { Object obj; obj = it.next(); Person p =
		 * (Person)obj; System.out.print(p.getName()+"..."+p.getAge()); }
		 */
		a1.remove(0);
		System.out.println(a1);

	}

	public static ArrayList singleElement(ArrayList a1) // ����һ�����飬ɾ����ͬ��Ԫ��
	{
		ArrayList newA1 = new ArrayList();
		Iterator it = a1.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (!(newA1.contains(obj)))
				newA1.add(obj);
		}
		return newA1;

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}

