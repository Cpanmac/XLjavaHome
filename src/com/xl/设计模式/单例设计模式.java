package com.xl.���ģʽ;

/*
���ģʽ��������������Ч�ķ���
java��23�����ģʽ��
�������ģʽ�����һ�������ڴ���ֻ����һ������.

��Ҫ��֤����Ψһ��
1.Ϊ�˱������������������Ƚ�ֹ�����������������
2.��Ϊ��������������Է��ʵ��������ֻ���ڱ����У��Զ���һ������
3.Ϊ�˷�������������Զ������ķ��ʣ����Զ����ṩһЩ���ʷ�ʽ��

��������ô�ô�������
1.�����캯��˽�л���
2.�ڱ����д���һ���������
3.�ṩһ���������Ի�ȡ���ö���

����������ô����������ô������
����Ҫ������Ķ���֤���ڴ���Ψһʱ���ͽ����ϵ��������ϼ���

*/

class Single {
    private static Single s = new Single();                    //��Ա������˽�л�һ��

    private Single() {
    }

    public static Single getInstance()   //   //Instance  ʵ��   Ϊ��ʹ����������������ǰ��+��̬static
    {
        return s;
    }
}

class SingleDemo {
    public static void main(String[] args) {
        Single ss = Single.getInstance();
        Single s1 = Single.getInstance();           //����������ָ��ͬһ���࣬��Ϊ���ܱ�����
    }
}

class Student {
    private String name;
    private int age;
}

/*	private ����(){}
    private static ���� ������=new ����();
	pubilc static ���� ������()
	{
		return ������;
	}*/