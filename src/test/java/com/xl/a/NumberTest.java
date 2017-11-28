package com.xl.a;

import com.xl.util.NumberTool;
import com.xl.util.Print;
import org.junit.Test;

public class NumberTest {
    @Test
    public void numberTest() {
        Print.info(10 / 3);
        Print.info(10 % 3);
        Print.info(10 / 1000);
        Print.info(10 % 1000);
        Print.info(2001 / 1000);
        Print.info(2001 % 1000);
    }

    @Test
    public void keepTest() {
        Print.info(NumberTool.formateNumber(323.1212, "#.00"));//四舍五入了
        Print.info(NumberTool.formateNumber(323.1262, "#.00"));
        Print.info(NumberTool.formateNumber(323.1, "#.00"));
    }

    @Test
    public void longTest() {
        long a = 1;
        Print.info(a);
    }
}
