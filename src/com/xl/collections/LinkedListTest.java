package com.xl.collections;

/*
 * ʹ��LinkedListģ��һ����ջ���߶��е����ݽṹ�� ��ͬ���� ��ջ���Ƚ���� ��ͬһ��ˮ�� ���У��Ƚ��ȳ� First in First out FIFO
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

class DuiLie // ������ĿҪ�ǵ�����
{
    private LinkedList<Object> link; // ʡ��link

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
