package com.xl.base;

/*
��һ��Բ�κͳ����Ρ�
�����Ի�ȡ������������������ַǷ�����ֵ����Ϊ�ǻ�ȡ������ֵ�����
����ͨ���쳣��ʾ��
���ж����������л������

*/
class  NoValueException extends Exception
{
	public NoValueException(String message)
	{
		super(message);
	}

}




interface Shape                 //�������Ϊһ����չ���ܣ�Shape �����java�����������Ǻ�ɫ
{
	void getArea();            //û�в��������Ϳ��ǹ̶��ģ��޷���ȡ��ֻ��Ҫ��ȡ
}


class Rec implements Shape
{ 
	private int len,wid;                                    
	Rec(int len,int wid)throws NoValueException
	{
		if(len<=0 || wid<=0)                        //���⴦�����
	//		System.out.println("����");        
		throw new NoValueException("���ַǷ�");
	//	else   ����else                                       //�������̴���           ���ǽ�ϵĺܽ���
		{
		this.len=len;
		this.wid=wid;
		}
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}


class ExceptionTest1
{
	public static void main(String[] args)
	{
		Rec r;
		try {
			r = new Rec(-3,4);
			r.getArea();
		} catch (NoValueException e) {
			e.printStackTrace();
		}
		
	}
}