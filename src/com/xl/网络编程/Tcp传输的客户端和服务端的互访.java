package com.xl.������;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
class TransClient1 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 10005);
		// ���ľ�����ת���õĿ����д
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in)); // Դ�������ȡ���������������
		// BufferedWriter bufOut=new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));//����Ŀ��������������������
		// ����һ��socket����������ȡ����˷��صĴ�д��Ϣ
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream())); //
		String line = null;
		while ((line = bufr.readLine()) != null) { // ���ļ���
			System.out.println(line); // �鿴������������������
			// bufOut.write(line);
			// //����д���ʱ��ֻ�ܶ�ȡ�س�����֮ǰ������
			// bufOut.newLine();
			// bufOut.flush(); //д����������ȥ��

			if ("over".equals(line)) // д����ͻ��over����ȥ
				break;
			out.println(line);
			String str = bufIn.readLine(); // �����Ƿ���������������Ϣ
			System.out.println("server:" + str);

		}
		bufr.close();
		s.close();
	}
}

class TransServer1 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println("�ͻ���Ip" + ip);// ���Լ�����û����

		// OutputStream os=s.getOutputStream();

		// InputStream is =s.getInputStream();
		// Ҫһ���еĶ��ŷ���
		// ��ȡsocket��ȡ���е�����
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		// Ŀ�ġ�socket�����������д����д�뵽socket������������͸��ͻ���
		// BufferedWriter bufOut = new BufferedWriter(new
		// OutputStreamWriter(s.getOutputStream()));
		// ������Ĵ���
		PrintWriter out = new PrintWriter(s.getOutputStream(), true); // �ܽ����ַ������ܽ����ֽ��������Զ�ˢ�£�true��ʾ��Ч��ˢ��
		String line = null;
		while ((line = bufIn.readLine()) != null) // readLine�����س���������������Կͻ����Ǳ�д���ʱ��ֻ��д��س���֮ǰ������
		{
			System.out.println(line);
			// bufOut.write(line.toUpperCase()); // д��������ȥ��
			// bufOut.newLine();
			// bufOut.flush(); // ����Ҫˢ�£�
			out.println(line); // ���⻻�е��Զ�ˢ��

		}
		s.close();
		ss.close();

	}
}

public class Tcp����Ŀͻ��˺ͷ���˵Ļ��� {

}
