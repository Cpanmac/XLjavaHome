package com.xl.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class ��ȡת���� // InputStreamReader
{
	public static void main(String[] args) throws IOException
	{
		/*
		 * // ��ȡ����¼����� InputStream in = System.in; // ���ֽ�������ת�����ַ�������
		 * InputStreamReader isr = new InputStreamReader(in); //
		 * �Ժ�׺Ϊ������Reader������ // Ϊ�����Ч�ʣ����ַ������л�����������Ч������ʹ��BufferedReader
		 * BufferedReader bufr = new BufferedReader(isr); String line = null;
		 * while ((line = bufr.readLine()) != null) { if ("over".equals(line))
		 * // ���������� break; System.out.println(line.toUpperCase()); //
		 * �������ת���ɴ�д�������� } // bufr.close(); }
		 */
System.setIn(new FileInputStream("1.java"));  //�ı�Դ
System.setOut(new PrintStream("zzz.txt"));  //�ı�Ŀ��
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out); // ת�������
		BufferedWriter bufw = new BufferedWriter(osw); // ��newLine() ��ƽ̨����
		String line = null;
		while ((line = br.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\nҲ����,�������ܿ�ƽ̨
			bufw.newLine();
			bufw.flush();
		}
		osw.close();
		br.close();
		bufw.close();
	}
}
