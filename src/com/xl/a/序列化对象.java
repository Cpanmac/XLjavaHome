package com.xl.a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class 序列化对象 {
	public static void main(String[] args) throws FileNotFoundException, IOException,
	        ClassNotFoundException {
		writeObj();
		readObj();
	}
	
	public static void readObj() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
		序列化唯一标识 p = (序列化唯一标识) ois.readObject();
		System.out.println(p);
		ois.close();
	}
	
	public static void writeObj() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
		oos.writeObject(new 序列化唯一标识("lisi", 38));
		oos.close();
	}
}
