package com.xl.IO.�ֽ���ByteArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * �����ļ�Ҫ���õײ���Դ���������󲻵��õײ���Դ���ر�����Ч���رպ��Կ��Ե���,��������κ�IO�쳣
 * �ô����Զ�����������,��ǰ�������Ƕ���1024��������byte����
 * Ŀ�ģ��ڲ���װ�˿ɱ䳤�ȵ�byte����
 * �ص㣺�ڹ����ʱ����Ҫ��������Դ����������Դ��һ���ֽ�����
 * ByteArrayOutputStream�� �ڹ����ʱ����Ҫ����,�ڲ���װ�˿ɱ䳤�ȵ�byte���顣���������Ŀ�ĵ�
 * Դ�豸:
 * ���� System.in.  Ӳ�� FileStream  �ڴ� ArrayStream
 * Ŀ���豸��
 * ����̨ System.out Ӳ�� FileStream �ڴ� ArrayStream
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        // ����Դ��
        ByteArrayInputStream bis = new ByteArrayInputStream(Messages.getString("����1").getBytes());
        // ����Ŀ��
        ByteArrayOutputStream bos = new ByteArrayOutputStream();// ��ָ��Ŀ�ġ�
        System.out.println("û������:" + bos.size());
        // ���ڿ���Ƶ���Ķ�д
        int by1 = 0;
        while ((by1 = bis.read()) != -1) {
            System.out.println(by1);
            bos.write(by1);
        }
        System.out.println("�����size:" + bos.size());
        System.out.println(bos.toString()); // abc
    }
}