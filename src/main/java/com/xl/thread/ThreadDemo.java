package com.xl.thread;

import org.junit.Test;

public class ThreadDemo implements Runnable {
    private int num;

    @Override
    public void run() {
        System.out.println(num);
    }

    @Test
    public void test1() {
        System.out.println(1);
        num = 2;
        new Thread(this).run();
        num = 3;
        new Thread(this).run();
        System.out.println(4);
    }
}