package com.xl.������;

/*����
 ����һ��Ӧ�ó������ڽ���udpЭ�鴫�����ݲ�����ġ�

 ����udp�Ľ��նˣ�ͨ�������һ���˿ڣ���ʵ���Ǹ���������������Ӧ�ó��������ֱ�ʶ�������廰��ϵͳ���漴����
 ��������ȷ��Щ���ݹ�����ЩӦ�ó�����Դ���
 ˼·��
 1.����udpsocket����
 2.����һ�����ݰ�����ΪҪ�洢���ܵ����ֽ����ݡ���Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ
 3.ͨ��socket�����receive�����յ������ݴ����Ѿ�����õ����ݰ���
 4.ͨ�����ݰ���������й��ܡ�����Щ��ͬ������ȡ������ӡ�ڿ���̨��
 5.�ر���Դ
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Udp����
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// 1.����udpsocket���񣬽����˵�
		DatagramSocket ds = new DatagramSocket(1666); // �����˿ڣ�����д��while����,Ҫ����������д��һ���˿ڣ�����ְ��쳣
		// 2.����һ�����ݰ�����ΪҪ�洢���ܵ����ֽ����ݡ���Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ
		System.out.println("����������..");
	while(true)
	{
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// 3.ͨ��socket�����receive�����յ������ݴ����Ѿ�����õ����ݰ���
		ds.receive(dp);//����ʱ����
		// 4.ͨ�����ݰ���������й��ܡ�����Щ��ͬ������ȡ������ӡ�ڿ���̨��
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength()); // ��Ϊ���ݾ�һ���֣�����Ҫ1024
		int port = dp.getPort();
		System.out.println(ip + ".." + data + ".." + port);
		// 5.�ر���Դ
		ds.close();
	}

	}

}
