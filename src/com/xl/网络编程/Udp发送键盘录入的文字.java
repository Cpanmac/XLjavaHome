package com.xl.������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
//ע�����IP
public class Udp���ͼ���¼�������
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		DatagramSocket ds = new DatagramSocket();//���Ͷ˿�����Ĭ�϶˿�
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
		byte[] buf=	line.getBytes();//������Ǿͱ������
		DatagramPacket dp =new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.32"),10001);
		ds.send(dp);
		}
		ds.close();  //ѭ��������ʱ��ر�
	}

}
