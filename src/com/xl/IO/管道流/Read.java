package com.xl.IO.�ܵ���;

import java.io.IOException;
import java.io.PipedInputStream;

class Read implements Runnable  //��ȡ�߳�
{
    private PipedInputStream pis;

    Read(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run()   //����run����������ֻ�ܴ���
    {
        try {
            byte[] buf = new byte[1024];
            //��ȡǰû���ݣ�д������Ҫ��6��
            System.out.println("��ȡǰ��ȴ�...");
            int len = pis.read(buf);  // ����ȡ�����ݴ洢��buf���飬����ֵ��len
            String s = new String(buf, 0, len);  //ת�����ַ���
            System.out.println("��ȡ����..��������");
            System.out.println(s);
            pis.close();  //�ر���
        } catch (IOException e) {
            throw new RuntimeException("�ܵ���ȡ��ʧ�� ");
        }
    }
}