package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class WenshiApple extends Apple {
    @Override
    public void get() {
        Print.info("采集温室苹果");
    }
}
