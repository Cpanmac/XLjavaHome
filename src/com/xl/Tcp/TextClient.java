package com.xl.Tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class TextClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("192.168.1.254", 10006);
        BufferedReader bufr = new BufferedReader(new FileReader("ip.java"));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //		long time=System.currentTimeMillis();
        //��������������ͽ������
        //		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        //		dos.writeLong(time);
        //		out.print(time);
        String line = null;
        while ((line = bufr.readLine()) != null) // ��ΪԴ���ļ������Կ��Խ���
        {
            out.println(line);
        }
        //		out.println("over");
        //		dos.writeLong(time); //�Ǳ߽����ı��
        s.shutdownOutput();//�رտͻ��˵���������൱�ڸ����м����˽������
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = bufIn.readLine();
        System.out.println(str);
        bufr.close();
        s.close();
    }
}

