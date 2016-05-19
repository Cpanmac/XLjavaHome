package com.xl.base;

import org.junit.Test;

public class numberDemo {
    @Test
    public void test() {
        int len = 45;
        int num;
        for (int i = 0; i < len; i++) {
            num = i / 3;
            System.out.print(num + ":");
            System.out.println(i % 4);
        }
    }
}
