package com.xl.������ǿ;

import org.junit.Test;

import java.math.BigDecimal;

public class ���������� {
    @Test
    public void ����۸�() {
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
        // ����������ǲ���ȷ��,ֻ���ÿ�ѧ����,�����þ�ȷ����
        // ԭ��:���������ֻ��01,double 8���ֽ�64λ,�����ʱ�򽫼�����ת����ʱ��������
        // ���Ҫ���о�ȷ�����Ҫ��BigDecimal
        BigDecimal a = new BigDecimal("324521241234123412344545456234.11232134143123134134524523453454361");
        BigDecimal b = new BigDecimal("45674873543456454648854354464646546.00623324413123413523452131234234152346561234152213");
        BigDecimal rs = a.add(b);// ���
        rs = a.multiply(b); // ��
        // rs=a.divide(b);//��,�ᱨ�쳣,��Ϊ������
        rs = a.divide(b, 10, BigDecimal.ROUND_HALF_UP); // 10:����10λС��
        System.out.println(rs.toString());
    }

    // ��double���������
    @Test
    public void double��������() {
        double a = 0.1, b = 0.006;
        System.out.println(a + b); // 0.10600000000000001
        String s = "0.10600000000000001";
        char[] ch = s.toCharArray();
        System.out.println(ch.length);
        float b1 = 0.1f, b2 = 0.006f;
        System.out.println(b1 + b2);
    }
}
