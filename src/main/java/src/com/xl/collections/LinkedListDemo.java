package com.xl.collections;

import java.util.LinkedList;

class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        link.addFirst("java01");
        link.addFirst("java02");
        link.addFirst("java03");
        link.addFirst("java04");
        link.addFirst("java05");
        link.addFirst("java06");
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
        // 不用迭代器清空所有元素
        System.out.println(link.toArray());
    }
}
