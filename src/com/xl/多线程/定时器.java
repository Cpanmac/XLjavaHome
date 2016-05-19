package com.xl.���߳�;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ����
 * @Decription 1.����������߳����棬��junit������벻��ִ��
 * @date 2014��3��2��
 */
public class ��ʱ�� {
    public static void main(String[] args) throws InterruptedException {
        // Schedele���Ȼ���();
        // ��2�����һ�Σ���4�����һ�Σ���8�����һ��
        // ��������();
        ָ��ʱ�����ָ���ĵ���();
    }

    public static void ָ��ʱ�����ָ���ĵ���() {
        Date d = new Date();
        d.setMinutes(1);
        new Timer().schedule(new MyTimeTask(), d);
    }

    public static void ��������() throws InterruptedException {
        new Timer().schedule(new MyTimeTask(), 2000);
        while (true) {
            Thread.sleep(2000);
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void Schedele���Ȼ���() {
        // TimerTask:task:ִ�е�����,long delay:�ڶ��ٺ����ִ��,
        // long period:ִ�к�ÿ����
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("���Ƕ�ʱ�����������");
            }
        }, 10, 3000); // schedule:ʱ�̱����ȱ� �嵥����ϸ�� Ԥ���ƻ��� Ŀ¼
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyTimeTask extends TimerTask {
    /**
     * �ڲ��಻���Ǿ�̬�ģ�������Ǿ�̬�������ǲ�����
     */
    static long i = 2000;

    public MyTimeTask() {
        super();
    }

    @Override
    public void run() {
        System.out.println(i);
        new Timer().schedule(new MyTimeTask(), i = i * 2);
    }
}
