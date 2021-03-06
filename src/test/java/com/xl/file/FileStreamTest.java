package com.xl.file;

import com.xl.util.Print;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileStreamTest {
    File f = new File(FileStreamTest.class.getResource("/1.txt").getFile());

    @Test
    public void readFile_3() throws IOException {
        FileInputStream fis = new FileInputStream(f);
        int num = fis.available(); // 计算字节个数，回车换行算\r\n算两个！
        byte[] buf = new byte[num]; // 定义一个刚刚好的缓冲区，不用再循环
        fis.read(buf);
        Print.info(num);
        Print.info(new String(buf));
        fis.close();
    }

    public void readFile_1() throws IOException { // 一次读一个字节
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        while ((ch = fis.read()) != -1) { // 一次读 一个
            Print.info((char) ch);
        }
        fis.close();
    }

    @Test
    public void readFile_2() throws IOException {
        Print.info(11);
        FileInputStream fis = new FileInputStream(f);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) { // 记得要把字节数组传入
            Print.info(new String(buf, 0, len));
        }
        fis.close();
    }
}
