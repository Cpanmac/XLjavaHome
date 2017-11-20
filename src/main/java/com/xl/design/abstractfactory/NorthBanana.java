package com.xl.design.abstractfactory;

import com.xl.util.Print;

public class NorthBanana extends Banana {
    @Override
    public void get() {
        Print.println("采集北方香蕉");
    }
}
