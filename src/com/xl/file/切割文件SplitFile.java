package com.xl.file;

//要是切电影的话，一个流对象只切100M的数据，就换个流对象，防止内存溢出
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

//将一个文件分开多个文件
public class 切割文件SplitFile {
	public static void main(String[] args) throws IOException {
		// splitFile();
		merge();
	}

	// 合并
	public static void merge() throws IOException {
		ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>(); // 因为Vector效率低
		for (int x = 1; x < 3; x++) {
			a1.add(new FileInputStream("c:\\" + x + ".part")); // 关联，并添加到文件当中
		}
		final Iterator<FileInputStream> it = a1.iterator(); // 因为下面是匿名内部类，所以要用final修饰
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() { // 匿名内部类，Enumeration是接口
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

	public static void splitFile() throws IOException { // 切割
		FileInputStream fis = new FileInputStream("c:\\1.bmp");
		FileOutputStream fos = null;
		byte[] buf = new byte[1024 * 1024]; // 每个文件1M
		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("c:\\" + (count++) + ".part"); // 碎片文件可以后缀名是suipian
			fos.write(buf, 0, len);
			fos.close(); // 循环一次创建一个文件
		}
		fis.close();
	}
}
