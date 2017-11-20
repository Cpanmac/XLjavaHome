package com.xl.file;

import com.xl.util.FileTool;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException { // 为了演示简便
        // 创建一个读取流对象和制定名称的文件相关联。要保证文件是已经存在的，如果不存在会发生FileNotFoundException
        FileReader fr = new FileReader(FileTool.getResourceFile("1.txt"));
        char c;
        int ch = 0;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();
    }
}
