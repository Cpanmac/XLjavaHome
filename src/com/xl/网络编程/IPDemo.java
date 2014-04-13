package com.xl.网络编程;

import java.net.InetAddress;
/*
UDP的特点
1.将数据源和目的封装成数据包中，不需要建立连接
2.每个数据报的大小在限制在64k内
3.因无连接，是不可靠协议
4.不需要建立连接，速度快
*/
public class IPDemo
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost(); // 未知主机异常
		// System.out.println(i.toString());
		// System.out.println("主机名："+i.getHostName());
		// 获取任意一台主机的IP地址对象
		InetAddress ia = InetAddress.getByName("www.baidu.com");
		byte[] buf = ia.getAddress();
		System.out.println("地址;" + ia.getHostAddress());
		System.out.println("主机名：" + ia.getHostName());// 需要解析过程
		// 如果IP地址没有在网络上，解析不成功，就只能返回这个IP地址
		// byte[] buf = InetAddress.getAllByName("www.baidu.com");
		for (byte b : buf)
		{
			System.out.print(b + " ");
		}

	}
}
