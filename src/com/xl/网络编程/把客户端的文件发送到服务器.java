package com.xl.������;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TextClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 10006);
		BufferedReader bufr = new BufferedReader(new FileReader("ip.java"));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		String line = null;
		while ((line = bufr.readLine()) != null) // ��ΪԴ���ļ������Կ��Խ���
		{
			out.println(line);
		}
		// ���������ܽ���
		out.println("over");
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);
		bufr.close();
		s.close();

	}
}

class TextServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10006);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip);
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
		// ���ǵ�Ӧ�ð�����ȡһ���������ͬ���ж�һ��
		PrintWriter out = new PrintWriter(new FileWriter(
				"C:\\Documents and Settings\\All Users\\����\\server.txt"), true);
		String line = null;
		while ((line = bufIn.readLine()) != null) {
			if ("over".equals(line))
				break;
			out.println(line);
		}

		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println("�ϴ��ɹ���");
		out.close();
		s.close();
		ss.close();

	}
}

public class �ѿͻ��˵��ļ����͵������� {
}
