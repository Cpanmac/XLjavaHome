package com.xl.Tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10004);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println("�ͻ��˵�IP��ַ�ǣ�" + ip);
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));
		java.io.OutputStream out =  s.getOutputStream();
		Thread.sleep(5000);//����ʽ����
		out.write("�����յ�����Ҳ�ã��ͻ��˷���".getBytes());
		s.close();
		ss.close();
	}
}
