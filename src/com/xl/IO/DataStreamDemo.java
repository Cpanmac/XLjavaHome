package com.xl.IO;

import org.junit.Test;

import java.io.*;

/**
 * ע�⣺�����writeUIF(String str)д�Ļ�����ת��������������ֻ���ö�Ӧ�Ķ�ȡ��ʽ��ȡ,Ӣ�Ĳ��漰����
 *
 * @author Administrator
 */
public class DataStreamDemo {
    private File file = new File("D:/data");

    /**
     * д��
     *
     * @throws IOException
     */
    @Test
    public void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(1);
        dos.writeBoolean(true);
        dos.writeDouble(9452.123);
        dos.write(123);
        dos.writeInt(2);
        dos.close();
        System.out.println("D:/dataд��ɹ�");
    }

    /**
     * ��ȡ
     *
     * @throws IOException
     */
    @Test
    public void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        // �����Ļ��������������Ǵ����, �ȶ�double�Ļ� ���Ƕ��˸��ֽ�
        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();
        int num2 = dis.readInt();
        System.out.println("num=" + num);
        System.out.println("b=" + b);
        System.out.println("d=" + d);
        System.out.println("num2=" + num2);
        dis.close();
    }

    @Test
    public void readUTFDemo() throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        String s = dis.readUTF();
        System.out.println(s);
        System.out.println(dis.available());
        s = dis.readUTF();
        System.out.println(s);
    }

    @Test
    public void writeUTFDemo() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeUTF("hello"); // ������û�����
        dos.writeUTF("���");
        dos.close();
    }
}
