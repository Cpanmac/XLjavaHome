package com.xl.file;

//Ҫ���е�Ӱ�Ļ���һ��������ֻ��100M�����ݣ��ͻ��������󣬷�ֹ�ڴ����
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

//��һ���ļ��ֿ�����ļ�
public class �и��ļ�SplitFile {
	public static void main(String[] args) throws IOException {
		// splitFile();
		merge();
	}

	// �ϲ�
	public static void merge() throws IOException {
		ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>(); // ��ΪVectorЧ�ʵ�
		for (int x = 1; x < 3; x++) {
			a1.add(new FileInputStream("c:\\" + x + ".part")); // ����������ӵ��ļ�����
		}
		final Iterator<FileInputStream> it = a1.iterator(); // ��Ϊ�����������ڲ��࣬����Ҫ��final����
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() { // �����ڲ��࣬Enumeration�ǽӿ�
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			public FileInputStream nextElement() {
				return it.next();
			}
		};
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream("c:\\1.bmp");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		sis.close();
		fos.close();
	}

	public static void splitFile() throws IOException { // �и�
		FileInputStream fis = new FileInputStream("c:\\1.bmp");
		FileOutputStream fos = null;
		byte[] buf = new byte[1024 * 1024]; // ÿ���ļ�1M
		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("c:\\" + (count++) + ".part"); // ��Ƭ�ļ����Ժ�׺����suipian
			fos.write(buf, 0, len);
			fos.close(); // ѭ��һ�δ���һ���ļ�
		}
		fis.close();
	}
}
