package com.xl.base;

import com.xl.util.Print;
import org.junit.Test;

public class IntegerTest {
    @Test
    public void IntegerDemo() {
        int max = Integer.MAX_VALUE;
        Print.info(max);
        int min = Integer.MIN_VALUE;
        Print.info(min);
    }
}
