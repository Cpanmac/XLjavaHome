package com.xl.thread;

import com.xl.util.Print;
import org.junit.Test;

public class ThreadDemo implements Runnable {
    private int num;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            num = i;
            Print.info(num);
        }
    }

    @Test
    public void test1() {
        Print.info(1);
        num = 2;
        new Thread(this).run();
        num = 3;
        new Thread(this).run();
        Print.info(4);
    }
}
