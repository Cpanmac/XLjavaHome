package com.xl.Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer
{
	public static void main(String[] args) throws IOException
	{
		// ���������Socket���񣬲�����һ���˿�
		ServerSocket ss = new ServerSocket(10003);
		// ͨ��accept�������ӹ����Ŀͻ��˶���
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println("ip��ַ�ǣ�" + ip);

		// ��ȡ�ͻ��˷��͹��������ݣ���ôҪ�ÿͻ��˵Ķ����ȡ����ȡ����
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));
		// udpͨ�����ݰ���ȡ�Է�IP
		s.close(); // �ضԷ�,
		ss.close();// ��ѡ����
	}

}
