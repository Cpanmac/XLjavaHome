package com.xl.���ģʽ;

//װ�����ģʽ��
//����Ҫ�����еĶ�����й�����ǿʱ�����Զ����࣬�����еĶ����룬�������еĹ��ܣ����ṩ��ǿ���ܡ���ô�Զ���ĸ����Ϊװ���ࡣ
public class װ�����ģʽ {
	public static void main(String[] args) {
		Person p = new Person();
		// p.chifan(); �Ͳ����ϵĳԷ�������
		SuperPerson sp = new SuperPerson(p);
		sp.superChifan();
	}
}

class SuperPerson { // ���������װ��
	private Person p;

	SuperPerson(Person p) { // ��ǿ���˶�����
	}

	public void superChifan() { // ���super�Է�
		System.out.println("��θ��");
		System.out.println("�Է�");
		System.out.println("���	");
	}
}

class Person {
	public void chifan() {
		System.out.println("�Է�");
	}
}