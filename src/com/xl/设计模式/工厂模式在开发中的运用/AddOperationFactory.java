package com.xl.���ģʽ.����ģʽ�ڿ����е�����;

public class AddOperationFactory implements OperationFactory {
    public Operation getOperation() {
        return new AddOperation();
    }
}
