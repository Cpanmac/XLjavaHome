package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class NorthBanana extends Banana {
    @Override
    public void get() {
        Print.info("采集北方香蕉");
    }
}
