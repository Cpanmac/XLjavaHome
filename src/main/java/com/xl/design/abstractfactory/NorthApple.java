package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class NorthApple extends Apple {
    @Override
    public void get() {
        Print.info("采集北方苹果");
    }
}
