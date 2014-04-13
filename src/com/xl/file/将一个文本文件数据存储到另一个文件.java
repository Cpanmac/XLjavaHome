package com.xl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 �����ļ�
 Դ����Ϊ��Դ������ʹ�ö�ȡ��InputStream Reader
 �ǲ��ǲ����ı��ļ����ǣ�Reader
 ��������ȷ���� Ӳ�̡��ϵ�һ���ļ� 
 Reader��ϵ�п��Բ����ļ��Ķ���FileReader


 Ŀ�ģ�OutputStream Writer
 �Ƿ��Ǵ��ı���
 �ǣ�Writer.
 �豸��Ӳ�̣�һ���ļ�
 Writer��ϵ���Բ����ļ��Ķ�����FileWriter

 .*/
public class ��һ���ı��ļ����ݴ洢����һ���ļ�
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("out.txt");
		BufferedReader bfr=new BufferedReader(fr);
		FileWriter fw=new FileWriter("hae.txt");
		BufferedWriter bfw=new BufferedWriter(fw);
		String line=null;
		while ((line=bfr.readLine())!=null){
			bfw.write(line);
		}
		bfw.close();
		bfr.close();
	}
}
