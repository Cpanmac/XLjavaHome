package com.xl.a;

import com.xl.util.NumberTool;
import org.junit.Test;

public class NumberDemo {
    @Test
    public void numberTest() {
        System.out.println(10 / 3);
        System.out.println(10 % 3);
        System.out.println(10 / 1000);
        System.out.println(10 % 1000);
        System.out.println(2001 / 1000);
        System.out.println(2001 % 1000);
    }

    @Test
    public void keepTest() {
        System.out.println(NumberTool.formateNumber(323.1212, "#.00"));//四舍五入了
        System.out.println(NumberTool.formateNumber(323.1262, "#.00"));
        System.out.println(NumberTool.formateNumber(323.1, "#.00"));
    }
}
