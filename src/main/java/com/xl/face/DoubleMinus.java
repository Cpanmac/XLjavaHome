package com.xl.face;

import com.xl.util.Print;

import java.math.BigDecimal;

public class DoubleMinus {
    public static void main(String[] args) {
        Print.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
        System.out.printf("%.1f", 2.0 - 1.1);
        Print.println(2.0 - 1.1);
    }
}
