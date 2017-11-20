package com.xl.thread;

import com.xl.util.Print;
import org.junit.Test;

public class ThreadDemo implements Runnable {
    private int num;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            num = i;
            Print.println(num);
        }
    }

    @Test
    public void test1() {
        Print.println(1);
        num = 2;
        new Thread(this).run();
        num = 3;
        new Thread(this).run();
        Print.println(4);
    }
}
