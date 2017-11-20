package com.xl.a;

import com.xl.util.NumberTool;
import com.xl.util.Print;
import org.junit.Test;

public class NumberTest {
    @Test
    public void numberTest() {
        Print.println(10 / 3);
        Print.println(10 % 3);
        Print.println(10 / 1000);
        Print.println(10 % 1000);
        Print.println(2001 / 1000);
        Print.println(2001 % 1000);
    }

    @Test
    public void keepTest() {
        Print.println(NumberTool.formateNumber(323.1212, "#.00"));//四舍五入了
        Print.println(NumberTool.formateNumber(323.1262, "#.00"));
        Print.println(NumberTool.formateNumber(323.1, "#.00"));
    }
}
