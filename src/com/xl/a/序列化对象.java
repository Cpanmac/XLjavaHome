package com.xl.a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ���л����� {
	public static void main(String[] args) throws FileNotFoundException, IOException,
	        ClassNotFoundException {
		writeObj();
		readObj();
	}
	
	public static void readObj() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		���л�Ψһ��ʶ p = (���л�Ψһ��ʶ) ois.readObject();
		System.out.println(p);
		ois.close();
	}
	
	public static void writeObj() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		oos.writeObject(new ���л�Ψһ��ʶ("lisi", 38));
		oos.close();
	}
}
