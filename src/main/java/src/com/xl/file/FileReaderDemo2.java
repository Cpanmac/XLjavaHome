package com.xl.file;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args) {
        FileReader fr = null;
        char[] buf = new char[1024]; // 如果缓冲区超大，通常定义1024的整数倍，2K，1个字符2个字节，1024*2=2KB
        int num = 0;
        try {
            fr = new FileReader("demo.txt");
            // 定义一个字符数组，用于存储读到字符。该read(char[])返回的是读到字符个数
            while ((num = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, num));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
