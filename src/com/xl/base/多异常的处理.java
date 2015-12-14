package com.xl.base;

/*
����:�ڱ������г�����-1,Ҳ�Ǵ�������޷����������.
��ô����Ҫ�������������Զ��������

���ں����ڲ�������throw�׳����쳣����,�ͱ���Ҫ����Ӧ�Ĵ�����
Ҫô���ڲ�try catch����.
Ҫô�ں����������õ����ߴ���.

һ�������,�����ڳ����쳣,��������Ҫ����,
��Ϊ�������Ѿ����쳣��Ϣ�Ĳ��������.\
��������ֻҪ�ڹ���ʱ,���쳣��Ϣ���ݸ�����ͨ��super���.
��ô�Ϳ���ͨ��ֱ��getMessage������ȡ�Զ�����쳣��Ϣ.

�Զ����쳣:
�������Զ�����̳�Exception.

�̳�Exceptionԭ��
�쳣��ϵ��һ���ص�,�쳣����쳣���󶼱��׳� 
���Ƕ����п�����,�����������

 */

//�Զ��崦���쳣
class FuShuException extends Exception // ������Ŀ����Ϊ�����ɶ���
{
	private int value;

	public int getValue() {
		return value;
	}

	/*
	 * private String msg; //�����쳣��Ϣ,��д FuShuException(String msg) {
	 * this.msg=msg; } public String getMessage() { return msg; }
	 */
	FuShuException(String msg, int value) // �൱������Ĵ���
	{
		super(msg);
		this.value = value;
	}

}

class DemoTest {
	int div(int a, int b) throws FuShuException {
		if (b < 0) // ���С��0���ó���ֹͣ��ת
			throw new FuShuException("�����˳����Ǹ��������", b); // �ֶ�ͨ��throw�ؼ����׳��쳣����
		return a / b;
	}
}

class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			DemoTest d = new DemoTest();
			int x = d.div(4, -1);
			System.out.println("x=" + x);
		} catch (FuShuException e) {
			System.out.println(e.toString());
			System.out.println("����ĳ�����" + e.getValue());
		}
	}
}
