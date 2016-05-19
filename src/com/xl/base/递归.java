package com.xl.base;

public class 递归 {
    public static void main(String[] args) {
        double a = f(4);
        System.out.println(a);
    }

    public static double f(int x) {
        if (x == 1) // 是1就不递归
            return 1;
        else
            // 不是1就递归
            return x * f(x - 1);
    }
}
