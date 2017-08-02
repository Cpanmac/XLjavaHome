package com.xl.base;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryRecursive {
    public static LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("请输入要转化为二进制的数:");
        toBin(sr.nextInt());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }

    public static int toBin(int n) {
        if (n > 0) {
            list.addFirst(n % 2);
            return toBin(n / 2);
        } else
            return 1;
    }
}
