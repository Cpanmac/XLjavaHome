package com.xl.face;

import com.xl.util.Print;

public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;    //微秒
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;        //毫秒
        Print.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
