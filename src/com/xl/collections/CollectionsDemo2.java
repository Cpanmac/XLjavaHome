package com.xl.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class CollectionsDemo2 {
    public static void main(String[] args) {
        shuffleDemo();
    }

    public static void orderDemo() {
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator())); // 直接逆向输出，由长到短
        ts.add("abcds");
        ts.add("aaa");
        ts.add("kk");
        ts.add("c");
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void shuffleDemo() {
        List<String> list = new ArrayList<String>();
        list.add("abcds");
        list.add("aaa");
        list.add("kk");
        list.add("c");
        sop(list);
        Collections.shuffle(list);
        sop(list);
    }

    /*
     * 练习：fill方法可以将list集合中所有元素替换成指定元素。 将list集合中部分元素替换成指定元素。
     */
    public static void replaceAllDemo() {
        List<String> list = new ArrayList<String>();
        list.add("asddfg");
        list.add("asdfg");
        list.add("asdfassafg");
        list.add("aa");
        list.add("asdfg");
        sop(list);
        Collections.replaceAll(list, "aa", "qq"); // 将list中的aa替换成qq
        sop(list);
        Collections.reverse(list);
    }

    public static void fillDemo() {
        List<String> list = new ArrayList<String>();
        list.add("asdfg");
        list.add("asdfg");
        list.add("asdfg");
        list.add("asdfg");
        list.add("asdfg");
        list.add("asdfg");
        list.add("asdfg");
        sop(list);
        Collections.fill(list, "qq"); // 将list集合所有的元素替换成qq
        sop(list);
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
