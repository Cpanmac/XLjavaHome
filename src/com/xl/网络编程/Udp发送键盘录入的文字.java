package com.xl.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
//注意改下IP
public class Udp发送键盘录入的文字
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		DatagramSocket ds = new DatagramSocket();//发送端可以用默认端口
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
		byte[] buf=	line.getBytes();//如果不是就变成数组
		DatagramPacket dp =new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.32"),10001);
		ds.send(dp);
		}
		ds.close();  //循环结束的时候关闭
	}

}
