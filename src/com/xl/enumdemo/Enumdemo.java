package com.xl.enumdemo;

import org.junit.Test;

//�����java�࣬ÿһ��ö���൱һ��ö��ʵ������
//ע�⣺
//���캯������˽��
public class Enumdemo {
    @Test
    public void test() {
        // 1. ��ȡö�ٵ�����
        System.out.println(Grade.C.name());
        System.out.println(Grade.D.getValue());
        System.out.println(Grade.D.name());
        System.out.println(Grade.D.localeValue());
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
