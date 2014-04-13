package com.xl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*1.
 Դ������¼��
 Ŀ�ģ�����̨��
 2.���󣺰Ѽ���¼������ݴ洢���ļ���
 Դ�����̡�
 Ŀ�ģ��ļ�
 3.���󣺰�һ���ļ���ӡ������̨��
 Դ���ļ�
 Ŀ�ģ�����̨
 
�������Ļ������ɣ�
��ʹ��ľ����������кܶ࣬��֪��������һ����
ͨ��������ȷ����ɡ�
1.��ȷԴ��Ŀ�ġ�
	Դ����������InputStream Reader
	Ŀ�ģ��������OutputStream Writer.
2.�����������Ƿ��Ǵ��ı���
	�ǣ��ַ�����
	���ǣ��ֽ�����  //���Բ���ͼƬ����Ƶ
3.����ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
	ͨ���豸���������֣�
	Դ�豸���ڴ棬Ӳ�̣�����
	Ŀ���豸���ڴ棬Ӳ�̣�����̨��
 *
 *
 */
public class ����¼������ݴ洢���ļ�
{
	public static void main(String[] args) throws IOException
	{
		/*
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("out.txt")));

		String line = null;
		while ((line = bufr.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\nҲ����,�������ܿ�ƽ̨
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
		*/
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(
				"out.txt")));       //System.in�滻
	
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				System.out));   //new FileOutputStream("out.txt")

		String line = null;
		while ((line = bufr.readLine()) != null)
		{
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase()); // \r\nҲ����,�������ܿ�ƽ̨
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
	}
}
