package com.xl.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class �����ȡ����RandomAccessFileDemo {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        // writeFile();
        writeFile_2();
        readFile();
    }

    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "r"); // rֻ��
        // ���������е�ָ��
        // raf.seek(8); //ȡ��һ������
        // ����ָ�����ֽ���
        // raf.skipBytes(8); //�ź����ǲ���������
        byte[] buf = new byte[4]; // ��Ϊint ��4���ֽ�
        raf.read(buf);
        String name = new String(buf);// ���ַ�����ת��Ϊ�ַ���
        System.out.println("name= " + name); // ȡ������
        int age = raf.readInt();
        System.out.println("age=" + age);
        raf.close();
    }

    public static void writeFile_2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
        raf.write("����".getBytes()); // �������ļ���ֱ�����ļ�����д���ݣ������������������
        raf.writeInt(103);
        raf.close();
    }

    public static void writeFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw"); // rw��дģʽ
        raf.write("����".getBytes());
        // raf.write(97); // ���ı�������ʾ����a write����ֻдint�����8λ ���ĵ���GBK�ı�
        // raf.write(258); // ���ݶ�ʧ
        raf.writeInt(38); // ��˳������������
        raf.write("����".getBytes());
        raf.writeInt(23);
        raf.close();
    }
}
