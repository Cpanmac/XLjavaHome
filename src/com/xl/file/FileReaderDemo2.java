package com.xl.file;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args) {
        FileReader fr = null;
        char[] buf = new char[1024]; // �������������ͨ������1024����������2K��1���ַ�2���ֽڣ�1024*2=2KB
        int num = 0;
        try {
            fr = new FileReader("demo.txt");
            // ����һ���ַ����飬���ڴ洢�����ַ�����read(char[])���ص��Ƕ����ַ�����
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
