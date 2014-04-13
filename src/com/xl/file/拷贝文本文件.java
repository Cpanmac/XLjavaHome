package com.xl.file;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class 拷贝文本文件 {
	/**
	 * @param 将C盘一个文本文件复制到D盘
	 *            。 原理： 就是将C盘下的文件数据存储到D盘的一个文件中 步骤： 1.在D盘创建一个文件。用于存储C盘中的文件中的数据
	 *            2.定义读取流和C盘文件关联 3.通过不断的读写完成数据的存储。4.关闭资源 作者：徐立
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 方法一：先用字符数组存储C盘的内容，再copy到D盘
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("c:/hello.txt");
			fw = new FileWriter("d:/hello.txt");
			char[] buf = new char[1024]; // 建立字符数组存储读取到的数据
			int len = 0; // 专业取名为len
			while ((len = fr.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len)); // 打印文件中的内容,有参数不怕浪费空间
			}
			fw.write(buf);
		} 
//		catch (FileNotFoundException e) {
//			e.printStackTrace();		} 
		catch (IOException e) {
			throw new RuntimeException("读写失败");
		} finally {
			try {
				if (fr != null && fw != null) {
					fr.close();
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("错误");
			}
		}
		// copy_1();
	}
	// 方法二：读一个写一个,不太好
	public static void copy_1() throws IOException {
		FileWriter fw = new FileWriter("1.txt"); // 目的地
		FileReader fr = new FileReader("1.java"); // 关联已有文件
		int ch = 0;
		while ((ch = fr.read()) != -1) { // 读一个写一个
			fw.write(ch);
			System.out.println(ch);
		}
		fr.close();
		fw.close();
	}
}
