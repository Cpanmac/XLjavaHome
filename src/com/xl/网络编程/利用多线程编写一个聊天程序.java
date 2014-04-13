package com.xl.������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*

 �������ݵĲ��֣��ͷ����ݵĲ��֡�
 ����������Ҫͬʱִ�С�
 �Ǿ���Ҫ���̼߳�����
 һ���̸߳����գ�һ���̸߳��𷢡�
��Ϊ�պͷ������ǲ�һ�µġ�����Ҫ��������run������
��������������Ҫ��װ����������
 */
public class ���ö��̱߳�дһ���������
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket sendSocket=new DatagramSocket();
			DatagramSocket receSocket=new DatagramSocket(10002);
			new Thread(new Send(sendSocket)).start();
			new Thread(new Rece(receSocket)).start();
		}
		catch (SocketException e)
		{
			//�Զ����ɵ� catch ��
			throw new RuntimeException("������");
		}
	}
}

class Send implements Runnable{
	private DatagramSocket ds;
	Send(DatagramSocket ds){
		this.ds=ds;
	}
	public void run(){  //����Ҫtry
		try
		{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//�õ�ת����
			String line=null;
			while((line=bufr.readLine())!=null){
				if("886".equals(line))
					break;
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10002);//�����еķ��㲥
				ds.send(dp);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("����ʧ��");
		}
		
	}
	
	
	
	
	
}
class Rece implements Runnable
{
	private DatagramSocket ds;
	Rece(DatagramSocket ds){
		this.ds=ds;
	}
	public void run(){
		try
		{
			while(true){
				byte[] buf=new byte[1024];
				DatagramPacket dp=new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				//������֮ǰ����ip
				String ip=dp.getAddress().getHostAddress();
				String data=new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+":"+data);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("����ʧ��");
		}
	}
}