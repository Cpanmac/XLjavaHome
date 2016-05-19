package com.xl.base;

import java.util.Scanner;

/**
 * 5.凯撒加密（要求就只做加密） 随机入一个字母，出现的后移了3为的字母，对应关系如下： 比如 z -> c a -> d b -> e c -> f
 * ...
 */
public class 字母右移3位解密 { // 因为数字和字母可以相互转换，a对应数字97 b对应数字98
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入：");
        String name = input.next();// 从控制台输入字符串
        int num; // 定义num进行转换
        char[] ch = name.toCharArray();// 将输入的字符串转成字符
        for (int x = 0; x < ch.length; x++) {
            if (ch[x] >= 'x' && ch[x] <= 'z') { // 当大于x,小于z的时候如果再加3会导致超出字母的范围，要回到a，b，c的位置就减去23，（26个字母）
                num = ch[x] - 23; // 26-3=23，所以这里减去23
                ch[x] = (char) num; // 将num转化成字符并赋值给字符数组
            } else if (ch[x] >= 'X' && ch[x] <= 'Z') {// 这里是大写的
                num = ch[x] - 24;
                ch[x] = (char) num;
            } else {
                num = ch[x] + 3; // 这就是向右移动3位
                ch[x] = (char) num;
            }
        }
        for (char c : ch) { // 高级for循环，用于输出，可以换成普通for。
            System.out.print(c);
        }
    }
}