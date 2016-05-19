package com.xl.设计模式.工厂模式在开发中的运用;

public class AddOperationFactory implements OperationFactory {
    public Operation getOperation() {
        return new AddOperation();
    }
}
