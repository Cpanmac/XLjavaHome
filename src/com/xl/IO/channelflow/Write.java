package com.xl.IO.channelflow;

import java.io.PipedOutputStream;

public class Write implements Runnable  //д���߳�
{
    private PipedOutputStream pos;

    Write(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run()   //����run����������ֻ�ܴ���
    {
        try {
            //д��֮ǰ��д����߳�ͣһ�ᣬҪ���쳣
            Thread.sleep(6000); //sleep�ͷ�ִ��Ȩ
            pos.write("piped �� ��".getBytes());  //write����ֻ�ܽ���Byte��������
            pos.close();
        } catch (Exception e) {
            throw new RuntimeException("�ܵ������ʧ�� ");  //�ֳ�Ϊд��
        }
    }
}