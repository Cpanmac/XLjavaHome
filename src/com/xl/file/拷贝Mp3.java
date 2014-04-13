package com.xl.file;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class 拷贝Mp3 {
	public static void main(String[] args) {
		FileOutputStream fos = null; // 目标
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bim = null;
		// try { //不用缓冲区
		// fis = new FileInputStream("c:/1.mp3");
		// fos = new FileOutputStream("c:/2.mp3");
		// int len;
		// byte[] buf = new byte[1024];
		// while ((len = fis.read(buf)) != -1) {
		// fos.write(buf);
		// }
		// }
		try {
			long start = System.currentTimeMillis(); // 系统开始时间
			fis = new FileInputStream("c:/1.mp3");
			fos = new FileOutputStream("c:/2.mp3");
			bos = new BufferedOutputStream(fos);
			bim = new BufferedInputStream(fis);
			int by = 0; // 就没用数组了！
			while ((by = bim.read()) != -1) {
				bos.write(by);
			}
			long end = System.currentTimeMillis();
			System.out.println(start + "\n" + end);
			System.out.println((end - start) + "毫秒");
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("找不到文件");
		} finally {
			try {
				if (bim != null)
					bim.close();
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("读取关闭失败！");
			}
			try {
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("写入关闭失败！");
			}
		}
	}
}
