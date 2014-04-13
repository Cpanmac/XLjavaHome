package com.xl.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ×Ö·û»º³åÁ÷ {
	public static void main(String[] args) throws Exception
	{
		File f=new File("D:\\µç»°.txt");
		File f2=new File("D:\\1.txt");
		BufferedReader br=new BufferedReader(new FileReader(f));
		BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
		String s=null;
		while((s=br.readLine())!=null)
		{
			System.out.println(s);
			bw.write(s);
		
		}
		br.close();
		bw.close();
	}
}
