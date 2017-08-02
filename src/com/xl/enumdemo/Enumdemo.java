package com.xl.enumdemo;

import org.junit.Test;

//�����java�࣬ÿһ��ö���൱һ��ö��ʵ������
//ע�⣺
//���캯������˽��
public class Enumdemo {
    @Test
    public void test() {
        print(Grade.D);
    }

    public void print(Grade g) {
        String value = g.localeValue();
        System.out.println(value);
    }

    // ����ö�ٳ��÷���
    @Test
    public void test2() {
        // 1. ��ȡö�ٵ�����
        System.out.println(Grade.C.name());
        // 2.���ַ����ĳ�ö�١�valueOf
        String str = "B";
        // Grade g=Grade.valueOf(Grade.class,str);
        Grade g = Grade.valueOf(str);
        System.out.println(g);
        //		3.�������е�ö��ֵ,���ĵ���û�С�
        Grade[] gs = Grade.values();
        for (Grade g1 : gs) {
            System.out.println(g1);
        }
    }
}
// java5��ǰ
// class Grade{
// private Grade(){}
// public static final Grade A=new Grade();
// public static final Grade B=new Grade();
// public static final Grade C=new Grade();
// public static final Grade D=new Grade();
//	
// }
