package com.xl.����֪ʶ;

//�ڶ�̬�У�����ָ��������󣩳�Ա�������ص㣺
//�ڱ���ʱ�ڣ����������ͱ����������������Ƿ��е��õķ���������У�����ͨ�������û�б���ʧ�ܡ�
//������ʱ�ڣ����Ķ��������������Ƿ��е��õķ���
//�ܽ᣺��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұߡ�

class Fu {
	int num = 5;

	void method1() {
		System.out.println("Fu_1");
	}

	void method2() {
		System.out.println("fu_2");
	}

}

class Zi extends Fu {
	int num = 8;

	void method1() {
		System.out.println("zi_1");
	}

	void method3() {
		System.out.println("zi_3");
	}
}

class DuoDemo {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.method1();
		f.method2();
		// f.method3(); //����ʱ���г���
		System.out.print(f.num);

	}
}
