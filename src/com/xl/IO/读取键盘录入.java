package com.xl.IO;

/*
 ��ȡ����¼�롣
 System.out:��Ӧ�ı�׼����豸������̨��
 System,in����Ӧ��׼�������豸,���̡�
 */

import java.io.IOException;
import java.io.InputStream;

public class ��ȡ����¼�� // ReadIn
{
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        // int by = in.read(); //read�����������������ȴ�����¼��
        // int by1=in.read();
        // int by2=in.read();
        // System.out.println(by); //һ��ֻ��һ���ֽ�
        // System.out.println(by1);
        // System.out.println(by2);
        // System.out.println('\r'+0); //13
        // System.out.println('\n'+0); //10
        // Ҫ��һֱ��ȡ��һ��һ���ַ��Ķ�ȡ
        /*
         * int ch = 0; while ((ch = in.read()) != -1) { //
		 * �ǲ���������-1��-1,�������ַ���Ҫ����ֹ����Ctrl+C���� System.out.println(ch); }
		 * in.close();// ���Բ��ùء���
		 */
        // ��Ҫover��ʱ��ͣ�����������������һ���Դ�ӡ����
        int ch;
        StringBuilder sb = new StringBuilder(); // ����������
        /*
         * //û��ʹ��readLine��ȡһ�� while (true) { ch = in.read(); if (ch == '\r')
		 * continue; // ��ֹ��ǰѭ���������´�ѭ�� if (ch == '\n') // ������س���ʱ�� { String s =
		 * sb.toString(); // �����������ַ���ת��ΪString // if (s.endsWith("over")) //
		 * ����over�����ҵĴ��� if ("over".equals(s)) break;
		 * System.out.println(s.toUpperCase()); // ������Ǿʹ�ӡ�ַ�������д�� sb.delete(0,
		 * sb.length()); // ��ջ�����,û������ַ������ۼ� } else sb.append((char) ch); //
		 * �����������ַ����浽������ }
		 */
        // ����readLine������ȡһ��,������¼���read�������ֽ�����readLine�������ַ���BufferedReader�ķ���
        // ��ô���ֽ���ת�����ַ���
        //		����ת��
    }
}
