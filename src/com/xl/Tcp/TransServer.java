package com.xl.Tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(10005);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println("�ͻ���Ip" + ip);// ���Լ�����û����
        // OutputStream os=s.getOutputStream();
        // InputStream is =s.getInputStream();
        // Ҫһ���еĶ��ŷ���
        // ��ȡsocket��ȡ���е�����
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // Ŀ�ġ�socket�����������д����д�뵽socket������������͸��ͻ���
        //		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        //		������Ĵ���
        PrintWriter out = new PrintWriter(s.getOutputStream(), true); //�ܽ����ַ������ܽ����ֽ��������Զ�ˢ�£�true��ʾ��Ч��ˢ��
        String line = null;
        while ((line = bufIn.readLine()) != null) // readLine�����س���������������Կͻ����Ǳ�д���ʱ��ֻ��д��س���֮ǰ������
        {
            System.out.println(line);
            //			bufOut.write(line.toUpperCase()); // д��������ȥ��
            //			bufOut.newLine();
            //			bufOut.flush(); // ����Ҫˢ�£�
            out.println(line);  //���⻻�е��Զ�ˢ��
        }
        s.close();
        ss.close();
    }
}