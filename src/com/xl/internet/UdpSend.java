package com.xl.internet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 ����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ��
 ˼·��
 1.����updsocket���� //�ҵ��ʾ�
 2.�ṩ���ݣ��������ݷ�װ�����ݰ��С� 
 3.ͨ��socket�����͹��ܣ������ݰ����ͳ�ȥ
 4.�ر���Դ   //����Ҫ�õ��������ߵײ���Դ
 */
public class UdpSend {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //  �Զ����ɵķ������
        // 1.����udp����ͨ��DataGramSocket
        DatagramSocket ds = new DatagramSocket(1666);
        // 2ȷ�����ݲ���װ�����ݰ�
        byte[] buf = "udp ge men lai le".getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.32"), 1666);
        // 3.ͨ��Socket����ͨ�����е����ݰ����ͳ�ȥ
        ds.send(dp);
        // 4.�ر���Դ
        ds.close();
    }
}
