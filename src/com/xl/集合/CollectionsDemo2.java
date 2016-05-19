package com.xl.����;

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
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator())); // ֱ������������ɳ�����
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
     * ��ϰ��fill�������Խ�list����������Ԫ���滻��ָ��Ԫ�ء� ��list�����в���Ԫ���滻��ָ��Ԫ�ء�
     */
    public static void replaceAllDemo() {
        List<String> list = new ArrayList<String>();
        list.add("asddfg");
        list.add("asdfg");
        list.add("asdfassafg");
        list.add("aa");
        list.add("asdfg");
        sop(list);
        Collections.replaceAll(list, "aa", "qq"); // ��list�е�aa�滻��qq
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
        Collections.fill(list, "qq"); // ��list�������е�Ԫ���滻��qq
        sop(list);
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
