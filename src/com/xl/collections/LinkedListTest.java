package com.xl.collections;

/*
 * 使用LinkedList模拟一个堆栈或者队列的数据结构。 如同杯子 堆栈：先进后出 如同一个水管 队列：先进先出 First in First out FIFO
 */

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        DuiLie d1 = new DuiLie();
        d1.myAdd("java01");
        d1.myAdd("java02");
        d1.myAdd("java03");
        d1.myAdd("java04");
        while (!d1.isNull())
            System.out.println(d1.myGet());
    }
}

class DuiLie // 我们项目要们的容器
{
    private LinkedList<Object> link; // 省略link

    DuiLie() {
        link = new LinkedList<Object>();
    }

    public void myAdd(Object obj) {
        link.addFirst(obj);
    }

    public Object myGet() {
        return link.removeLast();
    }

    public boolean isNull() {
        return link.isEmpty();
    }
}
