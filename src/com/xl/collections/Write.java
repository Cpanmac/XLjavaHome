package com.xl.collections;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Write implements Runnable { // д��
    private PipedOutputStream out;

    Write(PipedOutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            System.out.println("��ʼд�����ݣ��ȴ�6���");
            Thread.sleep(6000);  //���߳���Ϣ6��
            out.write("piped la��a".getBytes());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException("�ܵ������ʧ��");
        } catch (InterruptedException e) {  //�����жϵ��쳣
            throw new RuntimeException("�ն��쳣");
        }
    }
}
