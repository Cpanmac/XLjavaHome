package com.xl.Tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/*
���󣺽���һ���ı�ת����������
�ͻ��˸�����˷����ı�������˻Ὣ�ı�ת���ɴ�д���ظ��ͻ���
���ҿͻ��˿��Բ��˵Ľ����ı�ת�������ͻ�������over��ת������

������
�ͻ��ˣ�
��Ȼ�ǲ����豸�ϵ����ݣ���ô����ʹ��IO����������װio����˼��
Դ������¼��
Ŀ�ģ������豸�������������
���Ҳ������������ı����ݡ�����ѡ���ַ�����
����
1.��������
2.��ȡ����¼��
3.�����ݷ�������ˡ�
4.��ȡ����˷��صĴ�д���ݡ�
5.����������Դ��
�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʼ��뻺��

*/
public class TransClient{
	public static void main(String[] args) throws Exception
	{
		Socket s=new Socket("127.0.0.1",10005);
		//���ľ�����ת���õĿ����д
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in)); //Դ�������ȡ���������������
//		BufferedWriter bufOut=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//����Ŀ��������������������
		//����һ��socket����������ȡ����˷��صĴ�д��Ϣ
		PrintWriter out =new PrintWriter(s.getOutputStream(),true);
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream())); //
		String line=null; 
		while((line=bufr.readLine())!=null){  //���ļ���
			System.out.println(line); //�鿴������������������
//			bufOut.write(line);
//			//����д���ʱ��ֻ�ܶ�ȡ�س�����֮ǰ������
//			bufOut.newLine();
//			bufOut.flush(); //д����������ȥ��
		
			if("over".equals(line))  //д����ͻ��over����ȥ
				break;
			out.println(line);
			String str=bufIn.readLine(); //�����Ƿ���������������Ϣ
			System.out.println("server:"+str);
			
		}
		bufr.close();
		s.close();
	}
}

