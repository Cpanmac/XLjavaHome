package com.xl.file.randomAccess;

import com.xl.util.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * @author ����
 * @Decription ����ļ���ȡDemo
 * @date 2014-2-22
 */
public class RandomAccessFileDemo {
    private File file;

    @Before
    public void before() throws UnsupportedEncodingException {
        file = new File(FileTool.getCurrentPath(this), "1.txt");
    }

    public void read() throws IOException // ��ȡ
    {
        RandomAccessFile raf = new RandomAccessFile("1.txt", "r"); // ֻ���Ļ����������ε�ֻ��
        System.out.println(raf.read());
        // System.out.println(raf.read()); //ȡ��������192
        // Ҫ���ȡ����,�������ĸ��ֽڣ��͵ý�������
        byte[] buf = new byte[4];
        raf.read(buf); // ����buf�ĳ��ȣ����洢��buf����
        // ת�����ַ���
        String name = new String(buf);
        System.out.println("������" + name);
        System.out.println("����: " + raf.readInt());
    }

    public void read_2() throws IOException // ��ȡ����
    {
        // ��Ҫֱ�Ӷ�ȡ�м������,��Ϊ������4 ���� 15 �ĺ����ֽ�������
        RandomAccessFile raf = new RandomAccessFile("1.txt", "r");
        raf.seek(9); // writeд�����һ���ֽڣ�һ�������������ֽڣ�readInt��ȡ4���ֽ�
        byte[] buf = new byte[4];
        raf.read(buf);
        String name = new String(buf);
        System.out.println("������" + name);
    }

    @Test
    public void read_3() throws IOException // skipBytes
    // ����ָ���ֽڣ�ֻ��������������������
    {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        int a = raf.skipBytes(3);
        System.out.println(a);
    }

    /**
     * ���Ԫ��,ϣ���ڵ��ĸ�λ���������,ֱ��д��ָ��λ�ã��������ļ�
     *
     * @throws IOException
     */
    @Test
    public void write() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(13);
        raf.write("����".getBytes());
        raf.writeInt(103);
        raf.close();
    }

    @Test
    public void write2() throws IOException // д��
    {
        RandomAccessFile raf = new RandomAccessFile(file, "rws");
        raf.write(4); // ֻ�Ḳ���ļ�
        raf.write("����".getBytes()); // ������4���ֽ�
        raf.writeInt(15); // д��age
        raf.write("����".getBytes()); // ������4���ֽ�
        raf.writeInt(16); // д��age
    }
}
