package com.xl.collections;
/*
集合框架的工具类。
Collections

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void sortDemo() {
        List<String> list = new ArrayList<String>();
        list.add("abcd");
        list.add("aaa");
        list.add("z");
        list.add("kkk");
        list.add("qq"); // 不具备比较性，不能排序
        sop(list);
        Collections.sort(list);
        sop(list);
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
