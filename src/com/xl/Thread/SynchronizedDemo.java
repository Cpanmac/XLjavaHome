package com.xl.thread;

/**
 * @author ����
 * @Decription ��ͳ�̻߳��⼼����synchronized<br/>
 * ����������û����������С�����¼�<br/>
 * synchronized�����ֻ��һ�Σ�����2�����׳������� <br/>
 * �������synchronized�����׳�����δ���ûִ�����ȥִ����������
 * @date 2014��3��3��
 */
public class SynchronizedDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        new SynchronizedDemo().init();
    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    outputer.output("zhangxiaoxiang");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Outputer.output3("lihuoming");
                }
            }
        }).start();
    }

    /**
     * @author ����
     * @Decription 1.ouput��ouput2��û����class�ϼӾ�̬����<br/>
     * 2.��class�ϼӾ�̬����ôoutput3�����̬������ͬ����
     * @date 2014��3��4��
     */
    static class Outputer {
        /**
         * ��̬���������ֽ���?
         *
         * @param name
         */
        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        /**
         * ����һ������
         *
         * @param name
         */
        public void output(String name) {
            int len = name.length();
            // synchronized �����������󣬱�������,this����output2ͬ��
            // Ouput.class ���뾲̬����ͬ��
            synchronized (this) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        /**
         * ������������������this������synchronized�����this�����뱾�������л���
         *
         * @param name
         */
        public synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
