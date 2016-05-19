package com.xl.多线程;

/**
 * @author 徐立
 * @Decription 子线程循环10次，主线程循环100，接着回到子线程10，接着再回到主线程循环100，如此循环50 <br/>
 * 1.新建一个类来控制<br/>
 * 2.通过建立boolean变量用来控制子线程线性
 * @date 2014年3月5日
 */
public class 传统线程同步通信技术 {
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
 * @author 徐立
 * @Decription 不是用boolean类型进行圈住代码，锁放在资源类上面，synchronized用什么对象，就用什么对象wait <br/>
 * 如果用if容易发生伪唤醒。所以用while
 * @date 2014年3月5日
 */
class Business {
    private boolean isSub = true;

    /**
     * 子线程
     */
    public synchronized void sub() {
        while (!isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        for (int i = 1; i < 11; i++) {
            System.out.println("子线程运行" + i);
        }
        isSub = false;
        this.notify();// 唤醒
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
            System.out.println("主线程运行" + i);
        }
        isSub = true;
        this.notify();
    }
}
