package com.xl.多线程;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 徐立
 * @Decription 1.必须放在主线程里面，用junit里面代码不能执行
 * @date 2014年3月2日
 */
public class 定时器 {
    public static void main(String[] args) throws InterruptedException {
        // Schedele调度基础();
        // 过2秒调度一次，过4秒调度一次，过8秒调度一次
        // 递增调度();
        指定时间进行指定的调度();
    }

    public static void 指定时间进行指定的调度() {
        Date d = new Date();
        d.setMinutes(1);
        new Timer().schedule(new MyTimeTask(), d);
    }

    public static void 递增调度() throws InterruptedException {
        new Timer().schedule(new MyTimeTask(), 2000);
        while (true) {
            Thread.sleep(2000);
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void Schedele调度基础() {
        // TimerTask:task:执行的任务,long delay:在多少毫秒后执行,
        // long period:执行后，每经过
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("这是定时器里面的内容");
            }
        }, 10, 3000); // schedule:时刻表，进度表； 清单，明细表； 预定计划； 目录
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
     * 内部类不能是静态的，如果不是静态的数字是不会变得
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
