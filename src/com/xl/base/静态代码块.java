package com.xl.base;

class StaticCod {
    static {
        System.out.println("a");
    }
    public void show() {
    }
}

class Demo1 {
    static {
        System.out.println("b");
    }

    static {
        System.out.println("c");
    }
    public static void main(String[] args) {
        new StaticCod();
        new StaticCod();
    }
}
//�����a  c  b 
