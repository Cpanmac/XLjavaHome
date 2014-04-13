package com.xl.IO.�ַ�����DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class DataStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		writeData();	
		readData();
	}

	public static void readData() throws IOException
	{
	//��˳�������Ϲ��,�����Ļ��Ǵ�ģ�
	DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
	int num = dis.readInt();
	boolean b = dis.readBoolean();
	double d = dis.readDouble();	
	String s = dis.readUTF();
	System.out.println("num="+num);
	System.out.println("b="+b);
	System.out.println("d="+d);
	System.out.println("s="+s);
	dis.close();
	}


	public static void writeData() throws IOException  //д��
	{
	DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
	dos.writeInt(234);  //4���ֽ�
	dos.writeBoolean(true);  //1���ֽ�
	dos.writeDouble(912.112); //8���ֽ� ���ɵ�txt�ļ��϶���13���ֽ�	
	dos.writeUTF("���");	//��UTF-8�޸İ�д�룬ֻ������Ӧ�Ķ�ȡ��ʽ��ȡ����ת������������
	dos.close();
	}

}