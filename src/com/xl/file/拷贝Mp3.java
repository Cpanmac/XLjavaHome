package com.xl.file;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ����Mp3 {
	public static void main(String[] args) {
		FileOutputStream fos = null; // Ŀ��
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bim = null;
		// try { //���û�����
		// fis = new FileInputStream("c:/1.mp3");
		// fos = new FileOutputStream("c:/2.mp3");
		// int len;
		// byte[] buf = new byte[1024];
		// while ((len = fis.read(buf)) != -1) {
		// fos.write(buf);
		// }
		// }
		try {
			long start = System.currentTimeMillis(); // ϵͳ��ʼʱ��
			fis = new FileInputStream("c:/1.mp3");
			fos = new FileOutputStream("c:/2.mp3");
			bos = new BufferedOutputStream(fos);
			bim = new BufferedInputStream(fis);
			int by = 0; // ��û�������ˣ�
			while ((by = bim.read()) != -1) {
				bos.write(by);
			}
			long end = System.currentTimeMillis();
			System.out.println(start + "\n" + end);
			System.out.println((end - start) + "����");
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("�Ҳ����ļ�");
		} finally {
			try {
				if (bim != null)
					bim.close();
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("��ȡ�ر�ʧ�ܣ�");
			}
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("д��ر�ʧ�ܣ�");
			}
		}
	}
}
