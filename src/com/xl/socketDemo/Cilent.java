package com.xl.socketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cilent {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket s = new Socket("127.0.0.1", 9900);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
		Scanner sr = new Scanner(System.in);
		System.out.print("�������˵�������");
		String name = sr.next();
		System.out.print("�������˵����䣺");
		int age = sr.nextInt();
		User p = new User();
		p.setName(name);
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(p);
		System.out.println("����ɹ�");
		pw.flush();
		pw.close();
		s.close();
	}
}
