package com.xl.design.factory;

public class SubtractionOperation extends Operation {
    @Override
    public double getResult() {
        double result = this.getNum1() - this.getNum2();
        return result;
    }
}
