package com.xl.Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TextServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10006);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip);
        //�ȶ�һ��long���͵Ľ������
        //		DataInputStream dis =new DataInputStream(s.getInputStream());
        //		long l=dis.readLong();//�Ȱ�ʱ���������
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // ���ǵ�Ӧ�ð�����ȡһ���������ͬ���ж�һ��
        PrintWriter out = new PrintWriter(new FileWriter("C:\\Documents and Settings\\All Users\\����\\server.txt"), true);
        String line = null;
        while ((line = bufIn.readLine()) != null) {
            out.println(line);
        }
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("�ϴ��ɹ���");
        out.close();
        s.close();
        ss.close();
    }
}