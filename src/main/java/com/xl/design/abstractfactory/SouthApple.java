package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class SouthApple extends Apple {
    @Override
    public void get() {
        Print.info("采集南方苹果");
    }
}
