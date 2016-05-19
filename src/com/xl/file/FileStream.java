package com.xl.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
    public static void main(String[] args) throws IOException {
        // writeFile();
        // readFile_2();
        readFile_3();
    }

    public static void readFile_3() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        int num = fis.available(); // 计算字节个数，回车换行算\r\n算两个！
        byte[] buf = new byte[num]; // 定义一个刚刚好的缓冲区，不用再循环
        fis.read(buf);
        System.out.println(num);
        System.out.println(new String(buf));
        fis.close();
    }

    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        fos.write("abcd".getBytes()); // 变成byte数组用get 变char数组用toCharArray
    }

    public static void readFile_1() throws IOException { // 一次读一个字节
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        while ((ch = fis.read()) != -1) { // 一次读 一个
            System.out.println((char) ch);
        }
        fis.close();
    }

    public static void readFile_2() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) { // 记得要把字节数组传入
            System.out.println(new String(buf, 0, len));
        }
        fis.close();
    }
}
