package com.xl.enumdemo;

import org.junit.Test;

//特殊的java类，每一个枚举相当一个枚举实例对象。
//注意：
//构造函数必须私有
public class Enumdemo {
    @Test
    public void test() {
        print(Grade.D);
    }

    public void print(Grade g) {
        String value = g.localeValue();
        System.out.println(value);
    }

    // 测试枚举常用方法
    @Test
    public void test2() {
        // 1. 获取枚举的名称
        System.out.println(Grade.C.name());
        // 2.将字符串改成枚举。valueOf
        String str = "B";
        // Grade g=Grade.valueOf(Grade.class,str);
        Grade g = Grade.valueOf(str);
        System.out.println(g);
        //		3.返回所有的枚举值,在文档中没有。
        Grade[] gs = Grade.values();
        for (Grade g1 : gs) {
            System.out.println(g1);
        }
    }
}
// java5以前
// class Grade{
// private Grade(){}
// public static final Grade A=new Grade();
// public static final Grade B=new Grade();
// public static final Grade C=new Grade();
// public static final Grade D=new Grade();
//	
// }
