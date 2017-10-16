package com.xl.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileStream {
    File f = new File(FileStream.class.getResource("/1.txt").getFile());

    @Test
    public void readFile_3() throws IOException {
        FileInputStream fis = new FileInputStream(f);
        int num = fis.available(); // �����ֽڸ������س�������\r\n��������
        byte[] buf = new byte[num]; // ����һ���ոպõĻ�������������ѭ��
        fis.read(buf);
        System.out.println(num);
        System.out.println(new String(buf));
        fis.close();
    }

    public void readFile_1() throws IOException { // һ�ζ�һ���ֽ�
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        while ((ch = fis.read()) != -1) { // һ�ζ� һ��
            System.out.println((char) ch);
        }
        fis.close();
    }

    @Test
    public void readFile_2() throws IOException {
        System.out.println(11);
        FileInputStream fis = new FileInputStream(f);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) { // �ǵ�Ҫ���ֽ����鴫��
            System.out.println(new String(buf, 0, len));
        }
        fis.close();
    }
}
