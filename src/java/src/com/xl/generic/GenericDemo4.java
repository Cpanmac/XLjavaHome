package com.xl.generic;

class GenericDemo4 {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.show("haha");
        d.print("hehe");
    }
}

class Demo {
    public <T> void show(T t) {
        System.out.println("show：" + t);
    }

    public <Q> void print(Q q) {
        System.out.println("print:" + q);
    }
}
