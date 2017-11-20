package com.xl.thread;

/**
 * @author 徐立
 * @Decription 传统线程互斥技术。synchronized<br/>
 * 出现了运行没运行完整的小概率事件<br/>
 * synchronized：最好只用一次，出现2次容易出现死锁 <br/>
 * 如果不用synchronized：容易出现这段代码没执行完就去执行其他代码
 * @date 2014年3月3日
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
     * @author 徐立
     * @Decription 1.ouput和ouput2是没有在class上加静态方法<br/>
     * 2.在class上加静态，那么output3这个静态方法能同步吗？
     * @date 2014年3月4日
     */
    static class Outputer {
        /**
         * 静态方法是用字节码?
         *
         * @param name
         */
        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
        }

        /**
         * 保护一块区域
         *
         * @param name
         */
        public void output(String name) {
            int len = name.length();
            // synchronized 里面放任意对象，保护代码,this是与output2同步
            // Ouput.class 是与静态方法同步
            synchronized (this) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
            }
        }

        /**
         * 保护整个方法，等于this，上面synchronized如果用this才能与本方法进行互斥
         *
         * @param name
         */
        public synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
        }
    }
}
