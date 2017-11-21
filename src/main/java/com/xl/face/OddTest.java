package com.xl.face;

import com.xl.util.Print;

public class OddTest {
    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static void main(String[] args) {
        for (int i = -10; i <= 10; i++) {
            Print.info(isOdd(i));
        }
    }
}
