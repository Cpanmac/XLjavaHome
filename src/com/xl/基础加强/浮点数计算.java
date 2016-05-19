package com.xl.基础加强;

import org.junit.Test;

import java.math.BigDecimal;

public class 浮点数计算 {
    @Test
    public void 计算价格() {
        double _a = 232121.2;
        int _b = 2;
        BigDecimal a = new BigDecimal(_a);
        BigDecimal b = new BigDecimal(_b);
        BigDecimal _result = a.multiply(b);
        double result = _result.doubleValue();
        System.out.println(result);
    }

    @Test
    public void test2() {
        // 浮点计算结果是不精确的,只能用科学计算,不能用精确运算
        // 原因:计算机里面只有01,double 8个字节64位,计算的时候将计算结果转化的时候后面溢出
        // 如果要进行精确运算就要用BigDecimal
        BigDecimal a = new BigDecimal("324521241234123412344545456234.11232134143123134134524523453454361");
        BigDecimal b = new BigDecimal("45674873543456454648854354464646546.00623324413123413523452131234234152346561234152213");
        BigDecimal rs = a.add(b);// 相加
        rs = a.multiply(b); // 乘
        // rs=a.divide(b);//除,会报异常,因为除不尽
        rs = a.divide(b, 10, BigDecimal.ROUND_HALF_UP); // 10:保留10位小数
        System.out.println(rs.toString());
    }

    // 用double计算会出误差
    @Test
    public void double计算出误差() {
        double a = 0.1, b = 0.006;
        System.out.println(a + b); // 0.10600000000000001
        String s = "0.10600000000000001";
        char[] ch = s.toCharArray();
        System.out.println(ch.length);
        float b1 = 0.1f, b2 = 0.006f;
        System.out.println(b1 + b2);
    }
}
