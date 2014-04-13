package com.xl.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;
//�ϲ��ļ�
public class �ϲ��ļ�SequenceInputStreamDemo {
	public static void main(String[] args) throws IOException {
		// ֻ��Vector������Enumeration
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("c:\\1.txt"));
		v.add(new FileInputStream("c:\\2.txt"));
		v.add(new FileInputStream("c:\\3.txt"));
		Enumeration<FileInputStream> en = v.elements(); // Enumeration���Ƶ�����
		SequenceInputStream sis = new SequenceInputStream(en); // ��3���ļ���ɴ���
		FileOutputStream fos = new FileOutputStream("c:\\4.txt");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.close();
		sis.close();
	}
}
