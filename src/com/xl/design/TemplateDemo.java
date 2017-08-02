package com.xl.design;

/*
需求：获取一段程序运行的时间。
原理：获取程序开始和结束的时间并相减即可。

获取时间：System.currentTimeMillis();

当代码完成优化后，就可以解决这类问题。

这种方式，模版方法设计模式。
什么是模版方法呢？
在定义功能时，功能的一部分是确定的，但是有一部分不确定，而确定的部分在使用不确定的部分，
那么久将不确定的部分暴露出去，由该类的子类去完成。
*/

abstract class GetTime {
    public final void getTime() {
        long start = System.currentTimeMillis();
        runcode();                        //这部分暴露出去
        long end = System.currentTimeMillis();
        System.out.println("毫秒：" + (end - start));
    }

    public abstract void runcode();
}

class SubTime extends GetTime {
    public void runcode() {
        for (int x = 0; x < 1000; x++) {
            System.out.print(x);
        }
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        SubTime gt = new SubTime();
        gt.getTime();
    }
}