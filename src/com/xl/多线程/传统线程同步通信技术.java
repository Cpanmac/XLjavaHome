package com.xl.���߳�;

/**
 * @author ����
 * @Decription ���߳�ѭ��10�Σ����߳�ѭ��100�����Żص����߳�10�������ٻص����߳�ѭ��100�����ѭ��50 <br/>
 * 1.�½�һ����������<br/>
 * 2.ͨ������boolean���������������߳�����
 * @date 2014��3��5��
 */
public class ��ͳ�߳�ͬ��ͨ�ż��� {
    public static void main(String[] args) {
        final Business b = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    b.sub();
                }
            }
        }).start();
        for (int i = 0; i < 100; i++) {
            b.main();
        }
    }
}

/**
 * @author ����
 * @Decription ������boolean���ͽ���Ȧס���룬��������Դ�����棬synchronized��ʲô���󣬾���ʲô����wait <br/>
 * �����if���׷���α���ѡ�������while
 * @date 2014��3��5��
 */
class Business {
    private boolean isSub = true;

    /**
     * ���߳�
     */
    public synchronized void sub() {
        while (!isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        for (int i = 1; i < 11; i++) {
            System.out.println("���߳�����" + i);
        }
        isSub = false;
        this.notify();// ����
    }

    public synchronized void main() {
        while (isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i < 101; i++) {
            System.out.println("���߳�����" + i);
        }
        isSub = true;
        this.notify();
    }
}
