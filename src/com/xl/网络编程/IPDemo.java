package com.xl.������;

import java.net.InetAddress;
/*
UDP���ص�
1.������Դ��Ŀ�ķ�װ�����ݰ��У�����Ҫ��������
2.ÿ�����ݱ��Ĵ�С��������64k��
3.�������ӣ��ǲ��ɿ�Э��
4.����Ҫ�������ӣ��ٶȿ�
*/
public class IPDemo
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost(); // δ֪�����쳣
		// System.out.println(i.toString());
		// System.out.println("��������"+i.getHostName());
		// ��ȡ����һ̨������IP��ַ����
		InetAddress ia = InetAddress.getByName("www.baidu.com");
		byte[] buf = ia.getAddress();
		System.out.println("��ַ;" + ia.getHostAddress());
		System.out.println("��������" + ia.getHostName());// ��Ҫ��������
		// ���IP��ַû���������ϣ��������ɹ�����ֻ�ܷ������IP��ַ
		// byte[] buf = InetAddress.getAllByName("www.baidu.com");
		for (byte b : buf)
		{
			System.out.print(b + " ");
		}

	}
}
