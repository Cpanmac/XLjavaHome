package com.xl.file;

import java.io.FileReader;
import java.io.IOException;

public class readLine原理 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("buf.txt");
		MyBufferedReader mbr = new MyBufferedReader(fr);
		String line = null;
		while ((line = mbr.myReadLine()) != null) {
			System.out.println(line);
		}
		mbr.myClose();
	}
}

// 这种设计模式成为装饰设计模式。
class MyBufferedReader { // 模拟readLine，因为数组比较麻烦，就用StringBuilder
	private FileReader r; // 其实就是对BufferedReader的增强

	MyBufferedReader(FileReader r) {
		this.r = r;
	}

	public String myReadLine() throws IOException {// 定义一个临时容器，因为最终还是要用String，里面不能try因为是功能所以抛出去,谁调用，谁处理
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while ((ch = r.read()) != -1) {
			if (ch == '\r') { // 如果读到\r就不读
				continue;
			}
			if (ch == '\n')
				return sb.toString();
			else
				sb.append((char) ch); // 添加字符到SringBuilder
		}
		// 因为如果最后一行没有\n这样最后一行没有返回，因此这要做个判断
		if (sb.length() != 0)
			return sb.toString();
		return null;
	}

	public void myClose() throws IOException {
		r.close();
	}
}
