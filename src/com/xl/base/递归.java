package com.xl.base;

public class �ݹ� {
    public static void main(String[] args) {
        double a = f(4);
        System.out.println(a);
    }

    public static double f(int x) {
        if (x == 1) // ��1�Ͳ��ݹ�
            return 1;
        else
            // ����1�͵ݹ�
            return x * f(x - 1);
    }
}
