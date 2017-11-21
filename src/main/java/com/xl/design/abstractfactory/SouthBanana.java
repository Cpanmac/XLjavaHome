package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class SouthBanana extends Banana {
    @Override
    public void get() {
        Print.info("采集南方香蕉");
    }
}
