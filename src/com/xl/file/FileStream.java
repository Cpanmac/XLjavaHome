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
        int num = fis.available(); // �����ֽڸ������س�������\r\n��������
        byte[] buf = new byte[num]; // ����һ���ոպõĻ�������������ѭ��
        fis.read(buf);
        System.out.println(num);
        System.out.println(new String(buf));
        fis.close();
    }

    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        fos.write("abcd".getBytes()); // ���byte������get ��char������toCharArray
    }

    public static void readFile_1() throws IOException { // һ�ζ�һ���ֽ�
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        while ((ch = fis.read()) != -1) { // һ�ζ� һ��
            System.out.println((char) ch);
        }
        fis.close();
    }

    public static void readFile_2() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) { // �ǵ�Ҫ���ֽ����鴫��
            System.out.println(new String(buf, 0, len));
        }
        fis.close();
    }
}
