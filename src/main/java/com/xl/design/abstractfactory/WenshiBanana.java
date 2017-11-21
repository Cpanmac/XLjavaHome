package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class WenshiBanana extends Banana {
    @Override
    public void get() {
        Print.info("采集温室香蕉");
    }
}
