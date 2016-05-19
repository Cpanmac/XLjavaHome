package com.itcast.√Ê ‘;

public class OddTest {
    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static void main(String[] args) {
        for (int i = -10; i <= 10; i++) {
            System.out.println(isOdd(i));
        }
    }
}
